package vn.t3h.class2109.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.repositories.CategoryRepository;
import vn.t3h.class2109.service.CategoryService;
import vn.t3h.class2109.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontEndHomeController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"/", "home"})
    public String homePage(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        return "frontend/home";
    }

    @RequestMapping(value = "cart")
    public String cart(Model model, @RequestParam Long user, @RequestParam Long product){
        // lưu vào cart
        return "redirect:home";
    }
}
