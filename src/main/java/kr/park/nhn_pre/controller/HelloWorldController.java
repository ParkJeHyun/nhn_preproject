package kr.park.nhn_pre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016-12-18.
 */

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String helloWorld(Model model){

        model.addAttribute("message","Hello NHN!");

        return "index";
    }
}
