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

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userDao.getUsersList());
        return "index";
    }
    @GetMapping("addUser")
    public String addUser(Model model) {
    model.addAttribute("user", new User());
    return "new";
    }
   @PostMapping("create")
    public  String create(@ModelAttribute("user") User user) {
    userDao.add(user);
    return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
    model.addAttribute("user", userDao.show(id));
    return "edit";
    }
    @PatchMapping("edit/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDao.update(id, user);
        return "redirect:/";
    }
    @PostMapping("del")
    public String delete(@RequestParam("id") int id) {
       userDao.delete(id);
        return "redirect:/";
    }
}
