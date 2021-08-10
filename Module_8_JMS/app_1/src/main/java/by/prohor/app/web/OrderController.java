package by.prohor.app.web;

import by.prohor.app.entity.Order;
import by.prohor.app.service.ServiceOrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Artsiom Prokharau 05.08.2021
 */

@Controller
public class OrderController {

    @Autowired
    private ServiceOrderSender service;

    @GetMapping("/")
    public String start() {
        return "create_order";
    }

    @PostMapping("/order")
    public String order(@ModelAttribute("order") Order order, Model model) {
        service.sendMessage(order);
        model.addAttribute("order", order);
        return "send";
    }
}
