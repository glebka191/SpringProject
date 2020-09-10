package com.innotech.Controllers;

import com.innotech.Entity.Role;
import com.innotech.Entity.User;
import com.innotech.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.CollectionTable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Controller
public class WebController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(){
        return "welcome";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        userRepo.save(user);
       // user.setRoles
        return "redirect:/login";
    }
}