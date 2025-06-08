package com.Login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Login.Entity.User;
import com.Login.Repository.UserRepo;
import com.Login.Service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService impl;
	@Autowired
	private UserRepo repo;
		@GetMapping("/")
		public String getLogin()
		{
			return "Login";
		}
		@GetMapping("/signup")
		public String getSignup()
		{
			return "Registration";
		}
		@PostMapping("/register")
		public String getSave(@ModelAttribute User user ,Model model, RedirectAttributes redirectAttributes)
		{
			if(user.getPass().equals(user.getConfirm()))
			{
				impl.save(user);
				model.addAttribute("success","Data Saved Successfully");
				return "/login";
			}
			else {
	            redirectAttributes.addFlashAttribute("failure", "Passwords do not match. Please try again.");
	            return "redirect:/signup";  // Use RedirectAttributes to pass messages after redirect
	        }
		}

		@PostMapping("/login")
		public String getLogins(@ModelAttribute User user,Model model,RedirectAttributes redirectAttributes) {
		List<User> duser = repo.findAll();
		for(User u :duser)
		{
			if(user.getEmail().equals(u.getEmail())&&user.getPass().equals(u.getPass()))
			{
				model.addAttribute("msgg", "Logged successfully");
				return "sample";
			}
		}
		redirectAttributes.addFlashAttribute("failure", "Login Failed");
		 return "redirect:/";
		}


}
