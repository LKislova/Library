package library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Любовь on 11.12.2014.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/main")
    public String menu() {
        return "Menu";
    }

}
