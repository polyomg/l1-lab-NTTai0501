package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import poly.edu.dao.ProductDAO;

@Controller
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @GetMapping("/product/index")
    public String index(Model model) {
        model.addAttribute("items", productDAO.findAll());
        return "product/index"; // → hiển thị templates/product/index.html
    }
}
