package com.easyportfolio.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.Principal;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//import org.apache.velocity.runtime.RuntimeConstants;
//import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.easyportfolio.dao.DetailRepository;
import com.easyportfolio.dao.UserRepository;
import com.easyportfolio.entities.DetailInfo;
import com.easyportfolio.entities.User;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.easyportfolio.helper.Message;



@Controller
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DetailRepository detailRepository;
	@GetMapping("/")
	private String home(Model model) {
		model.addAttribute("title","Home Page");
		return "index";
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
			return "createaccount";
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
}