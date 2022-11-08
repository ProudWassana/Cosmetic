package org.itsci.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebHomeController {
    @RequestMapping("/")
    public String showHome() {
        return "home";
    }
}
