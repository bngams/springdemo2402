package fr.cesi.toulouse.cda23.demospring0224.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    // HTTP - GET - /hello
    @RequestMapping(value = "/public/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello world";
    }
}
