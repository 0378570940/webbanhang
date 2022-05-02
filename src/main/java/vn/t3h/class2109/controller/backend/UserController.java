package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.UserDto;
import vn.t3h.class2109.entities.UserEntity;
import vn.t3h.class2109.service.UserService;
import vn.t3h.class2109.utils.Constants;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Arrays;

@Controller
@RequestMapping("backend/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "create")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("roles", Arrays.asList(Constants.Role.ADMIN, Constants.Role.USER));
        return "backend/user/create";
    }

    @RequestMapping(value = "list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer perpage) {
        try {
            model.addAttribute("data", userService.findAll(page, perpage, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "backend/user/list";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // đánh dấu đường dẫn của web
    public String taoMoiLoaiSanPham(RedirectAttributes model,
                                    @Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // viết hàm lưu vào db
        if (bindingResult.hasErrors()){
            model.addAttribute("roles", Arrays.asList(Constants.Role.ADMIN, Constants.Role.USER));
            return "backend/user/create";
        }
        UserEntity result = userService.save(userDto);
        if (result.getId() == null)
            model.addFlashAttribute("message", "Tạo mới thành công!");
        else
            model.addFlashAttribute("message", "Thao tác thất bại!");
        return "redirect:/backend/user/list";// đọc text từ file jsp và render ra html
    }
}
