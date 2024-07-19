package com.example.demo.User;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PutMapping
    public void registerNewUser(@RequestBody UserModel user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String username,
                           @RequestParam(required = false) String email) {
        userService.updateUser(userId, username, email);
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "loginpage";
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestParam String email, @RequestParam String pwd, Model model, HttpSession session) {
        UserModel user = userService.authenticate(email, pwd);
        if (user != null) {
            session.setAttribute("authUsername", user.getUsername());
            session.setAttribute("authId", user.getId());
            model.addAttribute("authUser", user);

            Long roleId = user.getRid();
            if (roleId != null) {
                if (roleId.equals(1L)) {
                    return "redirect:/ca/tablea"; // Redirect for admin
                } else if (roleId.equals(2L)) {
                    return "redirect:/manager/dashboard"; // Redirect for manager
                } else if (roleId.equals(3L)) {
                    return "redirect:/employee/dashboard"; // Redirect for employee
                } else if (roleId.equals(4L)) {
                    return "redirect:/user/dashboard"; // Redirect for general user
                }
            }
        } else {
            model.addAttribute("error", "Invalid email or password");
        }
        return "loginpage"; // Redirect back to the login page with an error message
    }

}
