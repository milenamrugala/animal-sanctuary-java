package pl.milenamrugala.animalsanctuary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // marks the class as a Spring MVC controller, which will handle HTTP requests and return responses
public class HomeController {

    @RequestMapping("/homepage") // used to map HTTP requests to handler methods in the controller
    @ResponseBody // indicates that the return value of the method should be bound to the web response body
    public String home() {
        return "Hello World!";
    }
}
