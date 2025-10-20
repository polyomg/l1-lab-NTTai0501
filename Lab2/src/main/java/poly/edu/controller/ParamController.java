package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParamController {

    // Hiển thị form
    @RequestMapping("/form")
    public String form() {
        return "form"; // trỏ tới form.html trong /templates
    }

    // Nhận dữ liệu từ URL và form
    @PostMapping("/save/{x}")
    public String save(@PathVariable("x") String x,
                       @RequestParam("y") String y,
                       Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "form"; // render lại form.html
    }
}
