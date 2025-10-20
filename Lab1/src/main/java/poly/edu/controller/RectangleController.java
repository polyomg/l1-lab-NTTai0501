package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RectangleController {

    @GetMapping("/rectangle/form")
    public String form() {
        return "rectangle";
    }
    
    @PostMapping("/rectangle/calc")
    public String calculate(
            @RequestParam("length") double length,
            @RequestParam("width") double width,
            Model model) {

        
        if (length <= 0 || width <= 0) {
            model.addAttribute("error", "❌ Chiều dài và chiều rộng phải > 0");
            return "rectangle";
        }

        
        double area = length * width;
        double perimeter = 2 * (length + width);

        
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);

        return "rectangle";
    }
}
