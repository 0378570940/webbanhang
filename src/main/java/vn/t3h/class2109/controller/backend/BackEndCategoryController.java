package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.CategoryDto;
import vn.t3h.class2109.paging.PagingAndSortObject;
import vn.t3h.class2109.paging.PagingAndSortParam;
import vn.t3h.class2109.service.CategoryService;

import java.sql.SQLException;

@Controller
@RequestMapping("backend/category")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class BackEndCategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "list")
    public String list(@PagingAndSortParam(path = "category") PagingAndSortObject page) {
        categoryService.findAll(page);
        return "backend/category/list";
    }

    @RequestMapping(value = "create")
    public String create(Model model) {
        model.addAttribute("categoryDto", new CategoryDto());
        return "backend/category/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // đánh dấu đường dẫn của web
    public String taoMoiLoaiSanPham(RedirectAttributes model, CategoryDto categoryDto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // viết hàm lưu vào db
        boolean result = categoryService.saveCategory(categoryDto);
        if (result){
            if (categoryDto.getId() == null)
                model.addFlashAttribute("message", "Tạo mới thành công!");
            else
                model.addFlashAttribute("message", "Sửa thành công!");
        }
        else
            model.addFlashAttribute("message", "Thao tác thất bại!");
        return "redirect:/backend/category/list";// đọc text từ file jsp và render ra html
    }



}
