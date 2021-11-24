package com.zendesk.ticket.viewer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomepageController {

    @RequestMapping("")
    public String getHomePage(){
        return "index";
    }
}
