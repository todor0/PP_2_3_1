package app.controller;


import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-edit")
    public String editUserForm(@RequestParam(required = false, value = "id") Long id
            , Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/user-edit")
    public String editUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete")
    public String deleteUser(@RequestParam(required = false, value = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }


}
