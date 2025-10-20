package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {

    // /a → hiển thị trang a.html
    @RequestMapping("/a")
    public String m1() {
        return "a";  // view a.html
    }

    // /b → forward sang /a, truyền message qua Model
    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a";   // ?1
    }

    // /c → redirect sang /a, truyền message qua RedirectAttributes
    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";  // ?2
    }

    // /d → forward sang /a nhưng lấy message từ hàm m4
    @RequestMapping("/d")
    public String m4(Model model) {
        model.addAttribute("message", "I come from d");
        return "forward:/a";   // ?3
    }
}
