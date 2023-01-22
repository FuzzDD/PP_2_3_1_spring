package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userDao;
    private static int count;

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userDao.show(id));
//        return "pages/show";
//    }
@GetMapping
    public String index(Model model) {
        model.addAttribute("users", userDao.getUsersList());
        return "/index";
    }
@GetMapping("/new")
    public String addUser(Model model) {
    model.addAttribute("user", new User());
    return "/new";
    }
    @PostMapping("/new")
    public  String create(@ModelAttribute("user") User user) {
        user.setId(++count);
    userDao.add(user);
    return "redirect:/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
    model.addAttribute("user", userDao.show(id));
    return "/show";
    }
    @GetMapping("/{id}/edit")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDao.update(id, user);
        return "redirect:/show";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
       userDao.delete(id);
        return "redirect:/show";
    }
}
