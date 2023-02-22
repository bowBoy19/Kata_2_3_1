package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "allusers";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "adduser";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getById(id));
        return "/updateuser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
