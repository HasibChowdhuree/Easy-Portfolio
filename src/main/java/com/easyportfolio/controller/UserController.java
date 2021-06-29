package com.easyportfolio.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyportfolio.dao.DetailRepository;
import com.easyportfolio.dao.UserRepository;
import com.easyportfolio.entities.DetailInfo;
import com.easyportfolio.entities.Education;
import com.easyportfolio.entities.Skill;
import com.easyportfolio.entities.User;

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
	//		System.out.println(details.getFirstName());
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
	@GetMapping("/inputform")
	private String inputInformation() {
		return "inputform";
	}
	@RequestMapping(path="/processinputform", method= RequestMethod.POST)
	private String ProcessInputForm(final DetailInfo details,final User tempuser,Model model, Principal principal) {
		String email = principal.getName();
		System.out.println(email);
		User user = userRepository.getUserByUserName(email);
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
	@GetMapping("/ex")
	private String exa(Model model) {
		return "ex";
	}
	@RequestMapping(path="/ex", method= RequestMethod.POST)
	private String exa(final User user, Model model) {
		List<Skill> skill= user.getSkills();
		System.out.println(skill.get(0).getCategory()+skill.get(0).getSkillName());
		return "user_dashboard";
	}
}