package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import poly.edu.dao.CategoryDAO;

@Controller
public class CategoryController {

    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/category/index")
    public String index(Model model) {
        model.addAttribute("items", categoryDAO.findAll());
        return "category/index"; // → hiển thị templates/category/index.html
    }
}
