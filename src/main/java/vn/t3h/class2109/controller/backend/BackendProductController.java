package vn.t3h.class2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.paging.PagingAndSortObject;
import vn.t3h.class2109.paging.PagingAndSortParam;
import vn.t3h.class2109.service.CategoryService;
import vn.t3h.class2109.service.ProductService;

import java.sql.SQLException;

@Controller
@RequestMapping("backend/product")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class BackendProductController {
    // 1: Tạo 1 trang chủ như hướng dẫn
    // 2: Tạo backend tạo mới sản phẩm và lưu vào db (Tên sản phẩm, thể loại,
    // nhãn hiệu, giá, mô tả, tình trạng, ảnh) sửa dụng boostrap
    // Tạo table danh sách sản phẩm có chức năng chỉnh sửa sản phẩm

    // 3: Phân trang cho trang danh sách sản phẩm
    // 4: Thêm phần upload ảnh cho phần tạo mới và sửa sản phẩm.
    // Hiển thị ảnh trên tranh chi tiết và danh sản phẩm
    // 5: Thêm sửa xó danh sách bảng category (Thên thể loại, mô tả,  id)
//    6: hiển thị trên trang chủ(fontend) danh sách sản phẩm theo thể loại, brand

    // tạo thêm sửa xóa, danh sách tài khoản(username, pasword, sdt, email, mô tả,
    // và quyền(ADMIN, NHAN_VIEN, KHACH_HANG))

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    // Load trang danh sách sản phẩm
    @RequestMapping(value = "list")
    public String list(Model model, @PagingAndSortParam(path = "product") PagingAndSortObject page) {
        productService.findAll(page);
        return "backend/product/list";
    }

    // Load trang tạo mới sản phẩm
    @RequestMapping(value = "create")
    public String create(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "backend/product/create";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("product", productService.detail(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("categories", categoryService.getAll());
        return "backend/product/edit";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(RedirectAttributes model, @PathVariable Long id) {

        boolean result = productService.delete(id);
        if (result)
            model.addFlashAttribute("message", "Xóa thành công!");
        else
            model.addFlashAttribute("message", "Xóa thất bại!");
        return "redirect:/backend/product/list";
    }

//    // Submit tạo mới sản phẩm
//    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    // đánh dấu đường dẫn của web
//    public String taoMoiSanPham(Model model, ProductDto productDto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
//        // viết hàm lưu vào db
//        boolean result = productService.saveProduct(productDto);
//        if (result){
//            if (productDto.getId() == null)
//                model.addAttribute("message", "Tạo mới thành công!");
//            else
//                model.addAttribute("message", "Sửa thành công!");
//        }
//        else
//            model.addAttribute("message", "Thao tác thất bại!");
//        return "backend/product/list";// đọc text từ file jsp và render ra html
//    }

    // Submit tạo mới sản phẩm
    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // đánh dấu đường dẫn của web
    public String taoMoiSanPham(RedirectAttributes model, ProductDto productDto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // viết hàm lưu vào db
        boolean result = productService.saveProduct(productDto);
        if (result){
            if (productDto.getId() == null)
                model.addFlashAttribute("message", "Tạo mới thành công!");
            else
                model.addFlashAttribute("message", "Sửa thành công!");
        }
        else
            model.addFlashAttribute("message", "Thao tác thất bại!");
        return "redirect:/backend/product/list";// đọc text từ file jsp và render ra html
    }

}
