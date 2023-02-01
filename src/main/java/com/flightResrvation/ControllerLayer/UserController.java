package com.flightResrvation.ControllerLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightResrvation.Entity.User;
import com.flightResrvation.Repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showLogin")
	public String showLogIn() {
		return "Login/login";
	}
  
	@RequestMapping("/showReg")
	public String showReg() {
		return "Login/showReg";
	}
	@RequestMapping("/saveReg")
	public String showReg(@ModelAttribute ("user") User user) {
		
		userRepo.save(user);
		return "Login/login";
	}
	@RequestMapping("/veryFyLogin")
	 public String veryFyLogIn(@RequestParam ("email") String email,@RequestParam ("password") String password,ModelMap model) {
		User user = userRepo.findByEmail(email);
		if(user!=null){
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "findFlights";
			}else {
				model.addAttribute("error", "invalid username/password");
				return "Login/login";
			}
	
			
	}else {
		model.addAttribute("error", "invalid username/password");
					return "Login/login";
	
	}
		
	}
	
	
		
		
		
	 }

