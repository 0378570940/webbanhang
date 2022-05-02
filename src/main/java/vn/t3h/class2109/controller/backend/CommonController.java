package vn.t3h.class2109.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import vn.t3h.class2109.dto.common.ResponseDto;
import vn.t3h.class2109.utils.FileUtils;

@Controller
@RequestMapping("backend/common")
public class CommonController {

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    @ResponseBody
    // trả về 1 nếu thàng công, 0 nếu lỗi
    public ResponseDto taoMoiLoaiSanPham(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = FileUtils.saveFile(file);
            ResponseDto responseDto = new ResponseDto(1, fileName);
            return responseDto;
        } catch (Exception e){
        }
        ResponseDto responseDto = new ResponseDto(0, file.getOriginalFilename());
        return responseDto;
    }
}
