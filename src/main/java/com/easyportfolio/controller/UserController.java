package com.easyportfolio.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easyportfolio.dao.*;
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
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// saving password in database in crypted form
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    // repository objects to insert, delete data from database 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DetailRepository detailRepository;
	@Autowired
	private ProfileLinkRepository profilelinkRepository;
	@Autowired
	private EducationRepository educationRepository;
	@Autowired
	private AchievementRepository achievementRepository;
	@Autowired
	private ExperienceRepository experienceRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ReferenceRepository referenceRepository;
	@Autowired
	private SkillRepository skillRepository;
	
	// GET method dashboard after logging in
	@RequestMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		try {
			model.addAttribute("title","Dashboard");
			String email = principal.getName();
			// getting user from database using email
			User user = userRepository.getUserByUserName(email);
			int userId = user.getDetailId();
			// getting user detail from database using userId
			DetailInfo details = detailRepository.getById(userId);
			byte[] image = details.getImage();
			// checking if image is null or not
			if(image.length>0)
				model.addAttribute("image", new String(image, "UTF-8"));
			model.addAttribute("user",user);
			return "user_dashboard";
		}
		catch(Exception e) {
			model.addAttribute("title","Dashboard");
			// getting information about logged in user
			String email = principal.getName();
			User user = userRepository.getUserByUserName(email);
			model.addAttribute(user);
			return "user_dashboard";
		}
	}
	// POST method dashboard to take data from dashboard, to take personal information from form 
	@RequestMapping(path="/dashboard", method=RequestMethod.POST)
	private String editDashboard(final DetailInfo details,final User tempuser,Model model, Principal principal,@RequestParam("file") MultipartFile file) throws IOException {
		String email = principal.getName();
		User user = userRepository.getUserByUserName(email);
		if(file!=null) {
			byte[] image = java.util.Base64.getEncoder().encode(file.getBytes());
			if(image.length>0)
				model.addAttribute("image", new String(image, "UTF-8"));
			details.setImage(image);
		}
		if(details!=null)
			user.setDetails(details);
		userRepository.save(user);
		model.addAttribute(user);
		return "user_dashboard";
	}


	// GET method for add education form
    @RequestMapping("/add-education")
    public String add_education(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Education - Easy Portfolio");
        model.addAttribute("education", new Education());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_education";
    }
    // POST method for add education form
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
    // GET method for add experience form
    @RequestMapping("/add-experience")
    public String add_experience(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Experience - Easy Portfolio");
        model.addAttribute("experience", new Experience());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_experience";
    }
    // POST method for add education form
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
    // GET method for add project form
	@RequestMapping("/add-project")
    public String add_project(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Project - Easy Portfolio");
        model.addAttribute("project", new Project());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_project";
    }
	// POST method for add project form
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
    // GET method for add skill form
	@RequestMapping("/add-skill")
    public String add_skill(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Skill - Easy Portfolio");
        model.addAttribute("skill", new Skill());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_skill";
    }
	// POST method for add skill form
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

    // GET method for add referece form
	@RequestMapping("/add-reference")
    public String add_reference(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Reference - Easy Portfolio");
        model.addAttribute("reference", new Reference());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_reference";
    }
	// POST method for add reference form
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

    // 	GET method for add achievement form
	@RequestMapping("/add-achievement")
    public String add_achievement(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Achievement - Easy Portfolio");
        model.addAttribute("achievement", new Achievement());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_achievement";
    }
	// 	POST method for add achievement form
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

    // 	GET method for add profilelink form
	@RequestMapping("/add-profile-link")
    public String add_profile_link(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        model.addAttribute("profilelink", new ProfileLinks());
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "user_add_profile_link";
    }
	 // POST method for add profilelink form
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
    // GET method for change password method 
    @GetMapping("/change-password")
    public String change_password(Model model, Principal principal) {
        model.addAttribute("title", "Change Password - Easy Portfolio");
    	String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_change_password";
    }
    // POST method for change password
    @PostMapping("/process-change-password")
    public String process_change_password(Model model, Principal principal, @RequestParam("oldPassword") String oldPassword, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, HttpSession session ){
        model.addAttribute("title", "Change Password - Easy Portfolio");
    	String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        try{
            if(password.length()<6) {
				throw new Exception("Password length must be at least 6");
			}
			if(!password.equals(confirmPassword)) {
				throw new Exception("Passwords did not match");
			}
            if(this.bCryptPasswordEncoder.matches(oldPassword, user.getPassword())){
                user.setPassword(this.bCryptPasswordEncoder.encode(password));
                this.userRepository.save(user);
                session.setAttribute("message",new Message("Password Changed! ","alert-success"));
            }
            else{
                throw new Exception("Enter correct Old Password");
            }
            return "user_change_password";
        }
        catch(Exception e){
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
            return "user_change_password";
        }
    }

    // 	GET method for change username
    @GetMapping("/change-username")
    public String change_username(Model model, Principal principal) {
        model.addAttribute("title", "Change Username - Easy Portfolio");
    	String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_change_username";
    }
    // 	POST method for change username
    @PostMapping("/process-change-username")
    public String process_change_username(Model model, Principal principal, @RequestParam("username") String newusername, HttpSession session ){
        model.addAttribute("title", "Change Username - Easy Portfolio");
    	String userName = principal.getName(); 
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
        try{
			if(userRepository.findByUsername(newusername)!=null) {
				throw new Exception("Username already exits");
			}
            else{
                user.setUsername(newusername);
                this.userRepository.save(user);
                session.setAttribute("message",new Message("Username Changed! ","alert-success"));
            }
            return "user_change_username";
        }
        catch(Exception e){
			e.printStackTrace();
			session.setAttribute("message",new Message(e.getMessage(),"alert-danger"));
            return "user_change_username";
        }
    }
    // GET method for edit porfile link option
    @GetMapping("/edit-profilelink/{pId}")
    public String editProfileLink(@PathVariable("pId") int pId, Model model, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        ProfileLinks profilelink = profilelinkRepository.getById(pId);
        System.out.println(profilelink.getLink());
        model.addAttribute("profilelink", profilelink);
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_profile_link";
    }
    // POST method for edit profile link option
    @PostMapping("/edit-profilelink/{pId}")
    public String editProfileLinkProcess(@PathVariable("pId") int pId,final ProfileLinks profile, Model model,HttpSession session, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        ProfileLinks profilelink = profilelinkRepository.getById(pId);
        profilelink.setLink(profile.getLink());
        profilelink.setWebsite(profile.getWebsite());
        this.profilelinkRepository.save(profilelink);
        model.addAttribute("profilelink", profilelink);
        session.setAttribute("message",new Message("Updated! ","alert-success"));
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_profile_link";
    }
    // GET method for deleting profile link
    @GetMapping("/delete-profilelink/{pId}")
    public RedirectView deleteProfileLink(@PathVariable("pId") int pId,Model model,HttpSession session, Principal principal) {
    	ProfileLinks profilelink = profilelinkRepository.getById(pId);
    	String userName = principal.getName();
    	User user = userRepository.getUserByUserName(userName);
    	List<ProfileLinks> profilelinks = user.getProfile_links();
    	// to unlink object with user
    	for(int i=0;i<profilelinks.size();i++) {
    		ProfileLinks pro = profilelinks.get(i);
    		if(pro.getpId()==profilelink.getpId()) {
    			// unlinking object
    			profilelinks.set(i, null);
    			break;
    		}
    	}
    	session.setAttribute("message", new Message("deleted successfully","alert-danger"));
    	this.profilelinkRepository.delete(profilelink);
    	model.addAttribute("user", user);
    	return new RedirectView("/user/dashboard");
    }
    // GET method for edit education link option
    @GetMapping("/edit-education/{eId}")
    public String editEducation(@PathVariable("eId") int eId, Model model, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        Education education = educationRepository.getById(eId);
        model.addAttribute("education", education);
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_education";
    }
    // POST method for edit education link option
    @PostMapping("/edit-education/{eId}")
    public String editEducationProcess(@PathVariable("eId") int eId,final Education education, Model model,HttpSession session, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        education.seteId(eId);
        this.educationRepository.save(education);
        model.addAttribute("education", education);
        session.setAttribute("message",new Message("Updated! ","alert-success"));
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_education";
    }
    // GET method for deleting education link
    @GetMapping("/delete-education/{eId}")
    public RedirectView deleteEducationLink(@PathVariable("eId") int eId,Model model,HttpSession session, Principal principal) {
    	Education education = educationRepository.getById(eId);
    	String userName = principal.getName();
    	User user = userRepository.getUserByUserName(userName);
    	List<Education> educations = user.getEducations();
    	// to unlink object with user
    	for(int i=0;i<educations.size();i++) {
    		Education edu = educations.get(i);
    		if(edu.geteId()==education.geteId()) {
    			//unlinking object
    			educations.set(i, null);
    			break;
    		}
    	}
    	session.setAttribute("message", new Message("deleted successfully","alert-danger"));
    	this.educationRepository.delete(education);
    	model.addAttribute("user", user);
    	return new RedirectView("/user/dashboard");
    }
    // GET method for edit experience 
    @GetMapping("/edit-experience/{eId}")
    public String editExperience(@PathVariable("eId") int eId, Model model, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        Experience experience = experienceRepository.getById(eId);
        model.addAttribute("experience", experience);
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_experience";
    }
    // post method for edit experience 
    @PostMapping("/edit-experience/{eId}")
    public String editExperienceProcess(@PathVariable("eId") int eId,final Experience experience, Model model,HttpSession session, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        experience.seteId(eId);
        this.experienceRepository.save(experience);
        model.addAttribute("experience", experience);
        session.setAttribute("message",new Message("Updated! ","alert-success"));
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_experience";
    }
    // 	GET method for deleting experience 
    @GetMapping("/delete-experience/{eId}")
    public RedirectView deleteExperienceLink(@PathVariable("eId") int eId,Model model,HttpSession session, Principal principal) {
    	Experience experience = experienceRepository.getById(eId);
    	String userName = principal.getName();
    	User user = userRepository.getUserByUserName(userName);
    	List<Experience> experiences= user.getExperience();
    	// to unlink object with user
    	for(int i=0;i<experiences.size();i++) {
    		Experience exp = experiences.get(i);
    		if(exp.geteId()==experience.geteId()) {
    			//unlinking object
    			experiences.set(i, null);
    			break;
    		}
    	}
    	session.setAttribute("message", new Message("deleted successfully","alert-danger"));
    	this.experienceRepository.delete(experience);
    	model.addAttribute("user", user);
    	return new RedirectView("/user/dashboard");
    }
    // 	GET method for edit skill 
    @GetMapping("/edit-skill/{sId}")
    public String editSkill(@PathVariable("sId") int sId, Model model, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        Skill skill = skillRepository.getById(sId);
        model.addAttribute("skill", skill);
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_skill";
    }
    // 	POST method for edit skill 
    @PostMapping("/edit-skill/{sId}")
    public String editSkillProcess(@PathVariable("sId") int sId,final Skill skill, Model model,HttpSession session, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        skill.setsId(sId);
        this.skillRepository.save(skill);
        model.addAttribute("skill", skill);
        session.setAttribute("message",new Message("Updated! ","alert-success"));
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_skill";
    }
    // 	GET method for deleting skill 
    @GetMapping("/delete-skill/{sId}")
    public RedirectView deleteSkill(@PathVariable("sId") int sId,Model model,HttpSession session, Principal principal) {
    	Skill skill = skillRepository.getById(sId);
    	String userName = principal.getName();
    	User user = userRepository.getUserByUserName(userName);
    	List<Skill> skills= user.getSkills();
    	// to unlink object with user
    	for(int i=0;i<skills.size();i++) {
    		Skill sk = skills.get(i);
    		if(sk.getsId()==skill.getsId()) {
    			//unlinking object
    			skills.set(i, null);
    			break;
    		}
    	}
    	session.setAttribute("message", new Message("deleted successfully","alert-danger"));
    	this.skillRepository.delete(skill);
    	model.addAttribute("user", user);
    	return new RedirectView("/user/dashboard");
    }
    // 	GET method for edit project 
    @GetMapping("/edit-project/{pId}")
    public String editProject(@PathVariable("pId") int pId, Model model, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        Project project = projectRepository.getById(pId);
        model.addAttribute("project", project);
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_project";
    }
    // 	POST method for edit project 
    @PostMapping("/edit-project/{pId}")
    public String editProjectProcess(@PathVariable("pId") int pId,final Project project, Model model,HttpSession session, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        project.setpId(pId);
        this.projectRepository.save(project);
        model.addAttribute("project", project);
        session.setAttribute("message",new Message("Updated! ","alert-success"));
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_project";
    }
    // 	GET method for deleting project 
    @GetMapping("/delete-project/{pId}")
    public RedirectView deleteProject(@PathVariable("pId") int pId,Model model,HttpSession session, Principal principal) {
    	Project project = projectRepository.getById(pId);
    	String userName = principal.getName();
    	User user = userRepository.getUserByUserName(userName);
    	List<Project> projects = user.getProjects();
    	// to unlink object with user
    	for(int i=0;i<projects.size();i++) {
    		Project pr = projects.get(i);
    		if(pr.getpId()==project.getpId()) {
    			//unlinking object
    			projects.set(i, null);
    			break;
    		}
    	}
    	session.setAttribute("message", new Message("deleted successfully","alert-danger"));
    	this.projectRepository.delete(project);
    	model.addAttribute("user", user);
    	return new RedirectView("/user/dashboard");
    }
    // 	GET method for edit achievement
    @GetMapping("/edit-achievement/{aId}")
    public String editAchievement(@PathVariable("aId") int aId, Model model, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        Achievement achievement = achievementRepository.getById(aId);
        model.addAttribute("achievement", achievement);
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_achievement";
    }
    // 	POST method for edit achievement
    @PostMapping("/edit-achievement/{aId}")
    public String editAchievementProcess(@PathVariable("aId") int aId,final Achievement achievement, Model model,HttpSession session, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        achievement.setaId(aId);
        this.achievementRepository.save(achievement);
        model.addAttribute("achievement", achievement);
        session.setAttribute("message",new Message("Updated! ","alert-success"));
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_achievement";
    }
    // 	GET method for deleting achievement
    @GetMapping("/delete-achievement/{aId}")
    public RedirectView deleteAchievement(@PathVariable("aId") int aId,Model model,HttpSession session, Principal principal) {
    	Achievement achievement = achievementRepository.getById(aId);
    	String userName = principal.getName();
    	User user = userRepository.getUserByUserName(userName);
    	// to unlink object with user
    	List<Achievement> achievements= user.getAchievements();
    	for(int i=0;i<achievements.size();i++) {
    		Achievement ac = achievements.get(i);
    		if(ac.getaId()==achievement.getaId()) {
    			// unlinking object
    			achievements.set(i, null);
    			break;
    		}
    	}
    	session.setAttribute("message", new Message("deleted successfully","alert-danger"));
    	this.achievementRepository.delete(achievement);
    	model.addAttribute("user", user);
    	return new RedirectView("/user/dashboard");
    }
    // 	GET method for edit reference
    @GetMapping("/edit-reference/{rId}")
    public String editReference(@PathVariable("rId") int rId, Model model, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        Reference reference = referenceRepository.getById(rId);
        model.addAttribute("reference", reference);
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_reference";
    }
    // 	POST method for edit reference
    @PostMapping("/edit-reference/{rId}")
    public String editReferenceProcess(@PathVariable("rId") int rId,final Reference reference, Model model,HttpSession session, Principal principal) {
    	String userName = principal.getName();
        model.addAttribute("title", "Add Profile Link - Easy Portfolio");
        reference.setrId(rId);
        this.referenceRepository.save(reference);
        model.addAttribute("reference", reference);
        session.setAttribute("message",new Message("Updated! ","alert-success"));
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    	return "user_edit_reference";
    }
    // 	GET method for deleting reference
    @GetMapping("/delete-reference/{rId}")
    public RedirectView deleteReference(@PathVariable("rId") int rId,Model model,HttpSession session, Principal principal) {
    	Reference reference = referenceRepository.getById(rId);
    	String userName = principal.getName();
    	User user = userRepository.getUserByUserName(userName);
    	List<Reference> references= user.getReference();
    	// to unlink object with user
    	for(int i=0;i<references.size();i++) {
    		Reference rf = references.get(i);
    		if(rf.getrId()==reference.getrId()) {
    			//unlinking object 
    			references.set(i, null);
    			break;
    		}
    	}
    	session.setAttribute("message", new Message("deleted successfully","alert-danger"));
    	this.referenceRepository.delete(reference);
    	model.addAttribute("user", user);
    	return new RedirectView("/user/dashboard");
    }
}