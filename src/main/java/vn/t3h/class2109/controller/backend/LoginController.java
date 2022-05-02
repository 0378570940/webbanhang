package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.CategoryDto;
import vn.t3h.class2109.dto.UserDto;
import vn.t3h.class2109.service.UserService;

import java.sql.SQLException;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "_admin/login")
    public String homePage(){

        return "backend/login";
    }

    @RequestMapping(value = "register")
    public String register(){

        return "backend/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // đánh dấu đường dẫn của web
    public String dangKyTaiKhoanKhacHang(RedirectAttributes model, UserDto userDto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // viết hàm lưu vào db
        userService.save(userDto, UserService.DEACTIVE);
        userDto.setRole("CUSTOMER");
        model.addFlashAttribute("message", "Đăng ký thành công check email để xác nhận");
        return "redirect:/register";// đọc text từ file jsp và render ra html
    }

    @RequestMapping(value = "verify/{code}")
    // đánh dấu đường dẫn của web
    public String xacNhanTaiKhoan(RedirectAttributes model, @PathVariable String code) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // viết hàm lưu vào db
        userService.activeAcc(code);
        model.addFlashAttribute("message", "Xác nhận đăng ký tài khoản thành công");
        return "redirect:/_admin/login";// đọc text từ file jsp và render ra html
    }
}
