package vn.t3h.class2109.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.t3h.class2109.dto.KhachHangdto;

import java.sql.SQLException;

@RestController("CMSTextureController") // = @Controller + @ResponseBody
public class TestJsonController {
    @RequestMapping(value = "testrest", method = RequestMethod.GET)// đánh dấu đường dẫn của web
    public String add() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return "/WEB-INF/sua.jsp";// đọc text từ file jsp và render ra html
    }
}
