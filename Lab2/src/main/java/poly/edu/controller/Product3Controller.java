package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.model.Product;

@Controller
public class Product3Controller {

    @GetMapping("/product3/form")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "form3";
    }

    @PostMapping("/product3/save")
    public String save(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return "form3";
    }
}
