package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import jakarta.servlet.http.HttpSession;
import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDAO dao;

    @Autowired
    HttpSession session;

    // ===== Bài 1: Tìm sản phẩm theo khoảng giá =====
    @RequestMapping("/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search";
    }

    // ===== Bài 2: Tìm theo tên + phân trang =====
    @RequestMapping("/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {

        String keywords = kw.orElse((String) session.getAttribute("keywords"));
        if (keywords == null) {
            keywords = "";
        }
        session.setAttribute("keywords", keywords);

        Page<Product> page = dao.findByKeywords("%" + keywords + "%", PageRequest.of(p.orElse(0), 5));
        model.addAttribute("page", page);
        return "product/search-and-page";
    }
}
