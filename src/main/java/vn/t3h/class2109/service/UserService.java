package vn.t3h.class2109.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.t3h.class2109.dto.TableDataDto;
import vn.t3h.class2109.dto.UserDto;
import vn.t3h.class2109.entities.UserEntity;
import vn.t3h.class2109.paging.PagingAndSortObject;
import vn.t3h.class2109.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService implements TableService{

    public static final Integer ACTIVE = 1;
    public static final Integer DEACTIVE = 0;
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    public UserEntity save(UserDto userDto){
        return save(userDto, ACTIVE);
    }

    public UserEntity save(UserDto userDto, Integer status){
        UserEntity userEntity = userDto.mapperEntity();
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setStatus(status);
        userEntity.setCode(UUID.randomUUID().toString());
        userRepository.save(userEntity);

        // gửi email ở đây
        String title = "XÁC NHẬN ĐĂNG KÝ TÀI KHOẢN";
        String body = "Click vào đây " + "http://localhost:8080/verify/" + userEntity.getCode()
         + " để xác nhận đăng ký tài khoản với mật khẩu là: " + userDto.getPassword();

        try {
            emailService.sendMail(title, body, userDto.getUsername());
        } catch (Exception e) {
            throw new RuntimeException();// rollback
        }

        return userEntity;
    }

    public boolean activeAcc(String code) {
        UserEntity userEntity = userRepository.findFirstByCode(code);
        if (userEntity == null || userEntity.getStatus().equals(ACTIVE)) return false;

        userEntity.setStatus(ACTIVE);
        userRepository.save(userEntity);
        return true;

    }

    public TableDataDto findAll(Integer page, Integer perpage, String search) {
        TableDataDto result = new TableDataDto();
        List<UserEntity> userEntityList = userRepository.findAll();
        result.setData(userEntityList);
        return result;
    }

    @Override
    public void findAll(PagingAndSortObject page) {
        page.findAll(userRepository);
    }
}
