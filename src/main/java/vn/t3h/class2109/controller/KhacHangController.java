package vn.t3h.class2109.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.t3h.class2109.dto.KhachHangdto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Bước 1
@Controller// đánh dấu đây là 1 controller
public class KhacHangController {

    // 1: lấy thông tin khách hàng khi hánh hàng truyền id vào
    // 2: tìm kiếm tên khách hàng khi truyền tên vào
    // 3: Tạo 1 controller và jsp để tạo mới 1 khách hàng
    // 4: sửa thông tin khách hàng

    @RequestMapping(value = "khachhang/{name}", method = RequestMethod.GET)// đánh dấu đường dẫn của web
    public String home(Model model,
    @PathVariable String name,
    @RequestParam(required = false) String param
    ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List<KhachHangdto> khachHangdtos = getList();
        model.addAttribute("name", "danh sach khach hang");
        model.addAttribute("khachhangs", khachHangdtos);
        // model sẽ được lưu vào đâu
        // 1: response
        // 2: session
        return "/WEB-INF/home.jsp";// đọc text từ file jsp và render ra html
    }


    @RequestMapping(value = "khachhangforname", method = RequestMethod.GET)// đánh dấu đường dẫn của web
    public String khachhangfornamw(Model model,
                       @RequestParam(name = "name", required = false) String param
    ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List<KhachHangdto> khachHangdtos = getList();
        model.addAttribute("name", "danh sach khach hang");
        model.addAttribute("khachhangs", khachHangdtos);
        // model sẽ được lưu vào đâu
        // 1: response
        // 2: session
        return "/WEB-INF/home.jsp";// đọc text từ file jsp và render ra html
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)// đánh dấu đường dẫn của web
    public String add(Model model,
                      @RequestParam(name = "name", required = false) String param
    ) {
        return "/WEB-INF/them.jsp";// đọc text từ file jsp và render ra html
    }

    @RequestMapping(value = "them", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // đánh dấu đường dẫn của web
    public String themKhachHang(Model model, KhachHangdto khachHangdto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List<KhachHangdto> khachHangdtos = getList();
        model.addAttribute("name", "danh sach khach hang");
        model.addAttribute("khachhangs", khachHangdtos);
        return "/WEB-INF/home.jsp";// đọc text từ file jsp và render ra html
    }

    @RequestMapping(value = "them1", method = RequestMethod.POST)
    public String themKhachHang1(Model model, @RequestBody KhachHangdto khachHangdto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List<KhachHangdto> khachHangdtos = getList();
        model.addAttribute("name", "danh sach khach hang");
        model.addAttribute("khachhangs", khachHangdtos);
        return "/WEB-INF/home.jsp";// đọc text từ file jsp và render ra html
    }

    @RequestMapping(value = "them2", method = RequestMethod.POST)
    public String themKhachHang2(Model model, @ModelAttribute KhachHangdto khachHangdto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List<KhachHangdto> khachHangdtos = getList();
        model.addAttribute("name", "danh sach khach hang");
        model.addAttribute("khachhangs", khachHangdtos);
        return "/WEB-INF/home.jsp";// đọc text từ file jsp và render ra html
    }


    @RequestMapping(value = "sua/{id}", method = RequestMethod.GET)// đánh dấu đường dẫn của web
    public String add(@PathVariable long id, Model model) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        KhachHangdto khachHangdto = layKhachHangTheoId(id);// lấy từ db
        model.addAttribute("khachhang", khachHangdto);
        return "/WEB-INF/sua.jsp";// đọc text từ file jsp và render ra html
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(Model model, @ModelAttribute KhachHangdto khachHangdto) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List<KhachHangdto> khachHangdtos = getList();
        model.addAttribute("name", "danh sach khach hang");
        model.addAttribute("khachhangs", khachHangdtos);
        return "/WEB-INF/home.jsp";// đọc text từ file jsp và render ra html
    }


//    1: HttpServletRequest, HttpServletResponse
//    2: web server, container?
//    3: servlet, jsp,
//    4: session với cookie
//    5: jstl

// GET: Lấy dữ liệu (tìm kiếm trên db)
// POST: Thêm dữ liệu
// PUT: Sửa dữ liệu
// Delete: Xóa dữ liệu

//trong http
//1: phương thức: GET, POST, PUT, DELETE
//2: Đường dẫn @PathVariable
//3: param @RequestParam
//4: RequestBody : sử dung POST, PUT, DELETE



//    @RequestMapping("khachhang_1")
//    public void home1( HttpServletRequest request,
//                       HttpServletResponse response){
//        // Bước 1
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // bước 2
//        List<KhachHangdto> khachHangdtos = getList();
//        // Bước 3: đọc html từ file jsp
//        // bước 4 render text html từ text trong file jsp và biến truyền vào
////        response.setContentType("application/json");
//    // trả về
//        response.setCharacterEncoding("UTF-8");
//        out.print("<h1 style=\"font-weight: bold\">Xin chào 123<h1>");
//        out.flush();
//    }

    static String URL = "jdbc:mysql://localhost:3306/quanlybanhang";
    static String USER_NAME = "root";
    static String PASS_WORRD = "1234";

    public static List<KhachHangdto> getList() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        // bước 1: tạo connection đến db
//		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        List<KhachHangdto> result = new ArrayList<>();
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORRD);
        try {
            System.out.println("connection success");
            // Bước 2: tạo statement(pre statement)
//			Statement statement = connection.createStatement();// dành câu sql cố đinh
            // Bươc 3: tạo câu sql
//			String sql = "select * from khachhang k join hoadon h ON k.MAKH = h.MAKH";
            String sql = "select k.id, k.makh from khachhang k where k.ID = ? and k.MAKH = ?";
//			String mkh = "\"KH01\";delete khachhang;";
//			String sql = "select * from khachhang k where k.MAKH = " + mkh;
            // Bước 4 thực hiện câu lệnh
            PreparedStatement statement = connection.prepareStatement(sql);// có tham số
            statement.setLong(1, 1);
            statement.setString(2, "KH01");
            ResultSet resultSet = statement.executeQuery();
            // sql injnection
            // bước 5: xử lý dữ liệu trả về
            System.out.println("process");
            // Tạo biến khách hàng
            while (resultSet.next()) {
                KhachHangdto d = new KhachHangdto();
                System.out.println("===========");
                long id = resultSet.getLong(1);
                String makh = resultSet.getString(2);
                System.out.println("id = " + id + ", makh = " + makh);
                d.setId(id);
                d.setMakh(makh);
                result.add(d);

            }
        } finally {
            // bước 6 đóng connecttion
            connection.close();
        }
        return result;
    }

    public static KhachHangdto layKhachHangTheoId(Long idKhacHnag) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        // bước 1: tạo connection đến db
//		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        KhachHangdto result = new KhachHangdto();
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORRD);
        try {
            System.out.println("connection success");
            String sql = "select k.id, k.makh from khachhang k where k.ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);// có tham số
            statement.setLong(1, idKhacHnag);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("===========");
                long id = resultSet.getLong(1);
                String makh = resultSet.getString(2);
                System.out.println("id = " + id + ", makh = " + makh);
                result.setId(id);
                result.setMakh(makh);
                break;

            }
        } finally {
            // bước 6 đóng connecttion
            connection.close();
        }
        return result;
    }
}
