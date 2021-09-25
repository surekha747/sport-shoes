package com.simplilearn.sportyshoes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplilearn.sportyshoes.model.SignedUsers;
import com.simplilearn.sportyshoes.service.SignedUserService;

@Controller
@RequestMapping("/signeduserlist")
public class SignedUserController {

	@Autowired
	 SignedUserService service;
 
    @RequestMapping
    public String getAllUsers(Model model) 
    {
        List<SignedUsers> list = service.getAllSignedUserList();
 
        model.addAttribute("users", list);
        return "SignedUserList";
    }
    
    
    @RequestMapping(value="/search")
    public String getUserByEmail(SignedUsers signedUsers, Model model, String email) {
     if(email!=null) {
      List<SignedUsers> list = service.getUserByEmail(email);
      model.addAttribute("users", list);
     }else {
    	 List<SignedUsers> list = service.getAllSignedUserList();
     model.addAttribute("users", list);}
     return "SignedUserList";
    }
    
    
	/*
	 * @GetMapping("/showuser") public String getUserByEmail(Model model,
	 * 
	 * @ModelAttribute("signedUsers") SignedUsers signedUsers,BindingResult result)
	 * { List<SignedUsers> user =service.getUserByUserList(signedUsers.getEmail());
	 * model.addAttribute("userbyemail", user); return "SignedUserList"; }
	 */
}
