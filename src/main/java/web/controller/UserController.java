package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printUsers(ModelMap model) {
        model.addAttribute( "allUsers", userService.listUsers() );
        return "/users/allUsers";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam(name = "id") Long id, ModelMap model) {
        userService.removeUserById(id);
        return "redirect:/";
    }
     @GetMapping("/users/new")
     public String newUser(@ModelAttribute("user") User user) {
        return "/users/addForm";
    }
    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping("/users/change")
    public String changeUser(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("user", userService.findUser(id));
        return "/users/changeForm";
    }
    @PostMapping("/users/change")
    public String update( @ModelAttribute("user") User changedUser) {
        userService.update(changedUser);
        return "redirect:/";
    }

}
