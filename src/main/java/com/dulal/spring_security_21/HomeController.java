package com.dulal.spring_security_21;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public String processRegistration(@Valid @ModelAttribute("user") User user,
                                      BindingResult result, Model model){
        model.addAttribute("user", user);

        if(result.hasErrors()){
            return "registration";
        } else{
            userService.saveUser(user);
            model.addAttribute("message", "User Account SuccessFully Created");
        }
        return  "index";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/secure")
    public String secure() {
        return "secure";
    }

}
