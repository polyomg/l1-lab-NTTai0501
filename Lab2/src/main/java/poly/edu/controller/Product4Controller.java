package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.model.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Product4Controller {

    // Danh sách sản phẩm có sẵn
    private List<Product> items = new ArrayList<>(List.of(
            new Product("Laptop", 1200.0),
            new Product("Headphone", 150.0),
            new Product("Tablet", 800.0)
    ));

    @GetMapping("/product4/form")
    public String form(Model model) {
        model.addAttribute("product", new Product("iPhone 30", 5000.0)); // sản phẩm mặc định
        model.addAttribute("items", items);
        return "form4";
    }

    @PostMapping("/product4/save")
    public String save(@ModelAttribute Product product, Model model) {
        // Thêm sản phẩm mới vào danh sách
        items.add(product);

        // Gửi lại sản phẩm vừa nhập để hiển thị ở phần "Kết quả nhập"
        model.addAttribute("product", product);
        model.addAttribute("items", items);

        return "form4";
    }
}
