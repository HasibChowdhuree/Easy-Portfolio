package com.easyportfolio.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easyportfolio.dao.DetailRepository;
import com.easyportfolio.dao.UserRepository;
import com.easyportfolio.entities.Achievement;
import com.easyportfolio.entities.DetailInfo;
import com.easyportfolio.entities.Education;
import com.easyportfolio.entities.Experience;
import com.easyportfolio.entities.ProfileLinks;
import com.easyportfolio.entities.Project;
import com.easyportfolio.entities.Reference;
import com.easyportfolio.entities.Skill;
import com.easyportfolio.entities.User;
import com.easyportfolio.helper.Message;

import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DetailRepository detailRepository;
	@RequestMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		try {
			model.addAttribute("title","Dashboard");
			String email = principal.getName();
	//		System.out.println(email);
			User user = userRepository.getUserByUserName(email);
			int userId = user.getDetailId();
	//		System.out.println(userId);
			DetailInfo details = detailRepository.getById(userId);
			System.out.println(details.getFull_name());
			byte[] image = details.getImage();
	//		System.out.println(details.getFirstName());
			model.addAttribute("image", new String(image, "UTF-8"));
			model.addAttribute("user",user);
			return "user_dashboard";
		}
		catch(Exception e) {
			model.addAttribute("title","Dashboard");
			String email = principal.getName();
			User user = userRepository.getUserByUserName(email);
			model.addAttribute(user);
			return "user_dashboard";
		}
	}
	@RequestMapping(path="/dashboard", method=RequestMethod.POST)
	private String editDashboard(final DetailInfo details,final User tempuser,Model model, Principal principal,@RequestParam("file") MultipartFile file) throws IOException {
		String email = principal.getName();
		User user = userRepository.getUserByUserName(email);
		if(file!=null) {
			byte[] image = java.util.Base64.getEncoder().encode(file.getBytes());
			model.addAttribute("image", new String(image, "UTF-8"));
			details.setImage(image);
		}
		if(details!=null)
			user.setDetails(details);
		user.setEducations(tempuser.getEducations());
		user.setExperience(tempuser.getExperience());
		user.setProfile_links(tempuser.getProfile_links());
		user.setSkills(tempuser.getSkills());
		user.setProjects(tempuser.getProjects());
		user.setAchievements(tempuser.getAchievements());
		user.setReference(tempuser.getReference());
		userRepository.save(user);
		model.addAttribute(user);
		return "user_dashboard";
	}
	@GetMapping("/inputform")
	private String inputInformation(Principal principal, Model model) throws UnsupportedEncodingException {
		String email = principal.getName();
		User user = userRepository.getUserByUserName(email);
		int userId = user.getDetailId();
		DetailInfo details = detailRepository.getById(userId);
		byte[] image = details.getImage();
		model.addAttribute("image", new String(image, "UTF-8"));
		model.addAttribute(user);
		
		return "inputform";
	}
	@RequestMapping(path="/inputform", method= RequestMethod.POST)
	private String ProcessInputForm(final DetailInfo details,final User tempuser,Model model, Principal principal, @RequestParam("file") MultipartFile file) throws IOException {
		String email = principal.getName();
		User user = userRepository.getUserByUserName(email);
		if(file!=null) {
			byte[] image = java.util.Base64.getEncoder().encode(file.getBytes());
			model.addAttribute("image", new String(image, "UTF-8"));
			details.setImage(image);
		}
		if(details!=null)
			user.setDetails(details);
		user.setEducations(tempuser.getEducations());
		user.setExperience(tempuser.getExperience());
		user.setProfile_links(tempuser.getProfile_links());
		user.setSkills(tempuser.getSkills());
		user.setProjects(tempuser.getProjects());
		user.setAchievements(tempuser.getAchievements());
		user.setReference(tempuser.getReference());
		userRepository.save(user);
		model.addAttribute(user);
		return "inputform";
	}
	@GetMapping("/cv1")
	private String cv1(Model model) {
		return "CV01";
	}
	@GetMapping("/cv2")
	private String cv2(Model model) {
		return "CV02";
	}
	@RequestMapping(path="/ex", method= RequestMethod.POST)
	private String exa(final User user, Model model) {
		List<Skill> skill= user.getSkills();
		System.out.println(skill.get(0).getCategory()+skill.get(0).getSkillName());
		return "user_dashboard";
	}

	
    @RequestMapping("/add-education")
    public String add_education(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Education - Easy Portfolio");
        model.addAttribute("education", new Education());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_education";
    }
    @PostMapping("/process-add-education")
    public String process_new_eduation(@ModelAttribute Education education, Model model,  Principal principal, HttpSession session){
        model.addAttribute("title", "Add Education - Easy Portfolio");
        String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);

        try{
            user.getEducations().add(education);
            this.userRepository.save(user);
			session.setAttribute("message",new Message("Successfully added! ","alert-success"));
            return "user_add_education";
        }
        catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
			return "user_add_education";
		}
    }
	
    @RequestMapping("/add-experience")
    public String add_experience(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Experience - Easy Portfolio");
        model.addAttribute("experience", new Experience());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_experience";
    }
    @PostMapping("/process-add-experience")
    public String process_new_experience(@ModelAttribute Experience experience, Model model,  Principal principal, HttpSession session){
        model.addAttribute("title", "Add Experience - Easy Portfolio");
        String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);

        try{
            user.getExperience().add(experience);
            this.userRepository.save(user);
			session.setAttribute("message",new Message("Successfully added! ","alert-success"));
            return "user_add_experience";
        }
        catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
			return "user_add_experience";
		}
    }

	@RequestMapping("/add-project")
    public String add_project(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Project - Easy Portfolio");
        model.addAttribute("project", new Project());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_project";
    }
    @PostMapping("/process-add-project")
    public String process_new_project(@ModelAttribute Project project, Model model,  Principal principal, HttpSession session){
        model.addAttribute("title", "Add Project - Easy Portfolio");
        String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);

        try{
            user.getProjects().add(project);
            this.userRepository.save(user);
			session.setAttribute("message",new Message("Successfully added! ","alert-success"));
            return "user_add_project";
        }
        catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
			return "user_add_project";
		}
    }

	@RequestMapping("/add-skill")
    public String add_skill(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Skill - Easy Portfolio");
        model.addAttribute("skill", new Skill());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_skill";
    }
    @PostMapping("/process-add-skill")
    public String process_new_skill(@ModelAttribute Skill skill, Model model,  Principal principal, HttpSession session){
        model.addAttribute("title", "Add Skill - Easy Portfolio");
        String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);

        try{
            user.getSkills().add(skill);
            this.userRepository.save(user);
			session.setAttribute("message",new Message("Successfully added! ","alert-success"));
            return "user_add_skill";
        }
        catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
			return "user_add_skill";
		}
    }


	@RequestMapping("/add-reference")
    public String add_reference(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Reference - Easy Portfolio");
        model.addAttribute("reference", new Reference());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_reference";
    }
    @PostMapping("/process-add-reference")
    public String process_new_reference(@ModelAttribute Reference reference, Model model,  Principal principal, HttpSession session){
        model.addAttribute("title", "Add Reference - Easy Portfolio");
        String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);

        try{
            user.getReference().add(reference);
            this.userRepository.save(user);
			session.setAttribute("message",new Message("Successfully added! ","alert-success"));
            return "user_add_reference";
        }
        catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
			return "user_add_reference";
		}
    }


	@RequestMapping("/add-achievement")
    public String add_achievement(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Achievement - Easy Portfolio");
        model.addAttribute("achievement", new Achievement());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_achievement";
    }
    @PostMapping("/process-add-achievement")
    public String process_new_achievement(@ModelAttribute Achievement achievement, Model model,  Principal principal, HttpSession session){
        model.addAttribute("title", "Add Achievement - Easy Portfolio");
        String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);

        try{
            user.getAchievements().add(achievement);
            this.userRepository.save(user);
			session.setAttribute("message",new Message("Successfully added! ","alert-success"));
            return "user_add_achievement";
        }
        catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
			return "user_add_achievement";
		}
    }


	@RequestMapping("/add-profile-link")
    public String add_profile_link(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        model.addAttribute("profilelink", new ProfileLinks());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_profile_link";
    }
    @PostMapping("/process-add-profile-link")
    public String process_new_profile_link(@ModelAttribute ProfileLinks profileLinks, Model model,  Principal principal, HttpSession session){
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);

        try{
            user.getProfile_links().add(profileLinks);
            this.userRepository.save(user);
			session.setAttribute("message",new Message("Successfully added! ","alert-success"));
            return "user_add_profile_link";
        }
        catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
			return "user_add_profile_link";
		}
    }
}