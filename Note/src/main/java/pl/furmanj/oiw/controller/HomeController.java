package pl.furmanj.oiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Odwolanie do kontrolera
@Controller
public class HomeController {
    //Strona glowna
    @GetMapping
    public String index(){
        return "index";
    }
}
