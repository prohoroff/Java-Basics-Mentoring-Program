package by.prohor.app.web;

import by.prohor.app.entity.User;
import by.prohor.app.service.UserCommonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by Artsiom Prokharau 26.07.2021
 */

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserCommonServiceImpl userServiceImpl;


    @GetMapping("/")
    public String start(Model model) {
        List<User> allUsers = userServiceImpl.getAll();
        LOGGER.debug("get all users => {}", allUsers);
        model.addAttribute("allUser", allUsers);
        LOGGER.info("Method start. UserController (-- / --)");
        return "users";
    }

    @GetMapping("/create")
    public String name(@RequestParam(value = "id", required = false) String id, @RequestParam("name") String name, @RequestParam("email") String email) {
        LOGGER.debug("Create user with name ({}) and email ({})", name, email);
        User user;
        if (id.equals("")) {
            user = new User();
        } else {
            user = userServiceImpl.findById(Long.parseLong(id));
        }
        user.setName(name);
        user.setEmail(email);
        userServiceImpl.create(user);
        LOGGER.info("Method start. UserController (-- /create --)");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        LOGGER.debug("Delete user with id ({})", id);
        userServiceImpl.delete(id);
        LOGGER.info("Method start. UserController (-- /delete/{id} --)");
        return "redirect:/";
    }

    @GetMapping("/new")
    public String create() {
        LOGGER.info("Method start. UserController (-- /new --)");
        return "user_add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        LOGGER.info("Method start. UserController (-- /new --)");
        model.addAttribute("id", id);
        return "user_add";
    }
}

