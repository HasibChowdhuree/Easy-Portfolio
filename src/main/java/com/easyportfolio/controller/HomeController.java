package com.easyportfolio.controller;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.Principal;
import java.time.LocalDateTime;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//import org.apache.velocity.runtime.RuntimeConstants;
//import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.easyportfolio.dao.DetailRepository;
import com.easyportfolio.dao.UserRepository;
import com.easyportfolio.entities.DetailInfo;
import com.easyportfolio.entities.User;


import com.itextpdf.text.Document;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.easyportfolio.helper.Message;




@Controller
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DetailRepository detailRepository;
//	@Autowired
//    TemplateEngine templateEngine;
	
	@GetMapping("/")
	private String home(Model model, Principal principal) {
		model.addAttribute("title","Home Page");
		try {
			String email = principal.getName();
			User user = userRepository.getUserByUserName(email);
			model.addAttribute(user);
			return "index";
		}
		catch(Exception exception) {
			return "index";
		}
	}

	@RequestMapping("/createcv")
    public String CreateCV(Model model){
        model.addAttribute("title", "Create CV - Easy Portfolio");
        return "createcv";
    }
	
	@GetMapping("/signup")
	private String signup(Model model) {
		model.addAttribute("user",new User());
		return "signup";
	}
	@RequestMapping(path="/processsignup", method=RequestMethod.POST)
	private String ProcessSignup(@RequestParam("email") String email,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("confirmpassword") String cpassword,Model model,
			HttpSession session) {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		try {
			if(userRepository.findByEmail(email)!=null) {
				throw new Exception("user email already exists");
			}
			if(userRepository.findByUsername(username)!=null) {
				throw new Exception("username already exits");
			}
			if(password.length()<6) {
				throw new Exception("password length must be at least 6");
			}
			if(!password.equals(cpassword)) {
				System.out.println(password+" "+cpassword);
				System.out.println("password did not match");
				throw new Exception("password did not match");
			}
			user.setPassword(passwordEncoder.encode(password));
			user.setRole("ROLE_USER");
			this.userRepository.save(user);
			model.addAttribute("user",user);
			session.setAttribute("message",new Message("Successfully registered! ","alert-success"));
			return "signin";
		}
		catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
			return "signup";
		}
	}
	@GetMapping("/home")
	public String test(Model model) {
		model.addAttribute("title","demo home");
		return "home";
	}
	@RequestMapping(path="/signin")
	public String signin(Model model, Principal principal) {
		model.addAttribute("title","Sign in");
		try {
				String email = principal.getName();
				User user = userRepository.getUserByUserName(email);
				int userId = user.getDetailId();
				DetailInfo details = detailRepository.getById(userId);
				user.setDetails(details);
				model.addAttribute(user);
				return "user_dashboard";
		}
		catch(Exception e) {
			return "signin";
		}
	}
	
	@GetMapping("/genpdf/{fileName}")
	public HttpEntity<byte[]> createPdf(
            @PathVariable("fileName") String fileName, Principal principal, Model model) throws IOException {

		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();

		/* next, get the Template */
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.init();
		Template t = ve.getTemplate("templates/CV02.html");
		/* create a context and add data */
		VelocityContext context = new VelocityContext();
		String email = principal.getName();
		User user = userRepository.getUserByUserName(email);
		model.addAttribute("user", user);
		context.put("user", user); 
		context.put("genDateTime", LocalDateTime.now().toString());
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* show the World */
//		System.out.println(writer.toString());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		baos = generatePdf(writer.toString());

		HttpHeaders header = new HttpHeaders();
	    header.setContentType(MediaType.APPLICATION_PDF);
	    header.set(HttpHeaders.CONTENT_DISPOSITION,
	                   "attachment; filename=" + fileName.replace(" ", "_"));
	    header.setContentLength(baos.toByteArray().length);

	    return new HttpEntity<byte[]>(baos.toByteArray(), header);

	}
	
	public ByteArrayOutputStream generatePdf(String html) {

		PdfWriter pdfWriter = null;

		// create a new document
		Document document = new Document();
		try {

			document = new Document();
//			 document header attributes
			document.addAuthor("Rafsan");
			document.addAuthor("Hasib");
			document.addCreationDate();
			document.addProducer();
			document.addTitle("HTML to PDF using itext");
			document.setPageSize(PageSize.A4);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(
					html));
			// close the document
			document.close();
			System.out.println("PDF generated successfully");

			return baos;
		} catch (Exception e) {
			System.out.println("null");
			e.printStackTrace();
			return null;
		}

	}
	
}