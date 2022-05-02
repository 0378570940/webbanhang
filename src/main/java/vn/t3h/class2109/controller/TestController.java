package vn.t3h.class2109.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@Controller
public class TestController {
    @RequestMapping(value = "testController", method = RequestMethod.GET)// đánh dấu đường dẫn của web
    @ResponseBody// thì nó sẽ không tìm file jsp để đọc mà nó sẽ trả về dữ liệu dưới dạng json
    public String add() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return "/WEB-INF/home.jsp";// đọc text từ file jsp và render ra html
    }
}
