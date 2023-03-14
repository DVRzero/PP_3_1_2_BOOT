package ru.dvr.springboot.PP_3_1_2_BOOT.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dvr.springboot.PP_3_1_2_BOOT.entity.User;
import ru.dvr.springboot.PP_3_1_2_BOOT.service.UserService;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(ModelMap modelmap) {
        modelmap.addAttribute("allUsers", userService.getUsers());
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String addUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "adduser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/removeUser/{id}")
    public String removeUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/editUser/{id}")
    public String editUser(@PathVariable int id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping(value = "/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleException(IllegalArgumentException exp) {
        Map<String, String> map = new HashMap<>();
        map.put("Error", exp.getMessage());
        ModelAndView mav = new ModelAndView("exception", map);
        return mav;
    }
}