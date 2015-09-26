package com.appdirect.backend.rest.controllers;

import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cweerasekera
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, OpenIDAuthenticationToken authentication){
        model.addAttribute("authentication", authentication);
        return "show";
    }
}
