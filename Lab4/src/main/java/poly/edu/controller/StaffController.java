package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.model.Staff;

import java.io.File;
import java.io.IOException;

@Controller
public class StaffController {

    @RequestMapping("/staff/create/form")
    public String createForm(Model model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "staff-create";
    }

    @RequestMapping("/staff/create/save")
    public String createSave(Model model,
                             @ModelAttribute("staff") Staff staff,
                             @RequestParam("photo_file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // Lưu file vào thư mục static/images
            String uploadDir = "src/main/resources/static/images/";
            File saveFile = new File(uploadDir + file.getOriginalFilename());
            file.transferTo(saveFile);

            staff.setPhoto(file.getOriginalFilename());
        }
        model.addAttribute("message", "Xin chào " + staff.getFullname());
        model.addAttribute("staff", staff);
        return "staff-create";
    }
}
