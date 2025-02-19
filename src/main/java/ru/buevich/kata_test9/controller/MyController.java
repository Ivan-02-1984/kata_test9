package ru.buevich.kata_test9.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.buevich.kata_test9.models.User;
import ru.buevich.kata_test9.service.UserService;
import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {

    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        List<User> Users = userService.allUsers();
        model.addAttribute("allUser", Users);
        return "showAllUsers";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user_info";
    }

    @PostMapping
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam("userID") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit_user";
    }

    @PostMapping("/editUser")
    public String updateUser(@Valid @ModelAttribute("userID") User user, BindingResult bindingResult) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userID") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
