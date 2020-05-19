package com.example.demo.controller;


import com.example.demo.model.Animation;
import com.example.demo.model.User;
import com.example.demo.service.AnimationService;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller

@EnableAutoConfiguration
public class AnimationController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    @Qualifier("NumberService")
    public AnimationService animationService;

    @GetMapping({"/", "/animation"})
    String home(Model model){

        model.addAttribute("number", new Animation());

        return "animation";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/animationShow")
    String animationShow(@Valid @ModelAttribute("number") Animation e, BindingResult br,
                            @RequestParam HashMap<String, String> animationTable, ModelMap modelMap) {

        if (br.hasErrors()) {
            return "animation";
        } else {
            String name = animationTable.get("name");
            String genre = animationTable.get("genre");
            String year = animationTable.get("year");
            String groups = animationTable.get("groups");




            modelMap.put("name", name);
            modelMap.put("genre", genre);
            modelMap.put("year", year);
            modelMap.put("groups", groups);


            animationService.save(new Animation(name, genre, year, groups));

            return "animation";
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/animationTable")
    public String getAllNumbers(Model model) {
        model.addAttribute("animationTable", animationService.getAll());
        return "animationTable";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/show{id}")
    public String getById(@RequestParam("id") int id, Model model) {
        model.addAttribute("animation", animationService.getById(id));
        return "animation";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleting{id}")
    public String delete(@RequestParam("id") int id, Model model) {
        animationService.delete(id);
        model.addAttribute("animationTable", animationService.getAll());
        return "animationTable";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateAnimation{id}")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("animation", animationService.getById(id));
        return "updateAnimation";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateAnimation")
    public String updateNumber(@ModelAttribute("id") Animation animation) {
        animationService.update(animation);
        return "redirect:/show?id=" + animation.getId();
    }


    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect://localhost:8090";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Username or password is incorrect");

        if (logout != null)
            model.addAttribute("message", "Successfullly logged out");

        return "login";
    }


}

