package by.prohor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */

@Controller
public class AppController {

    //    @GetMapping("hello")
//    public String welcome(Principal principal, Model model) {
//        model.addAttribute("name", principal.getName());
//        return "welcome";
//    }
    @RequestMapping(value = "/hello")
    public String getProductName() {
        return "Honey";
    }
}
