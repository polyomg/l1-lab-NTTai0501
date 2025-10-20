package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    // OK 1: POST /ctrl/ok
    @PostMapping("/ok")
    public String m0(Model model) {
        model.addAttribute("message", "Đây là m0()");
        return "ok";
    }

    // OK 2: GET /ctrl/ok
    @GetMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("message", "Đây là m1()");
        return "ok";
    }

    // OK 3: POST /ctrl/ok2
    @PostMapping("/ok2")
    public String m2(Model model) {
        model.addAttribute("message", "Đây là m2()");
        return "ok";
    }
}
