package vn.t3h.class2109.dto;

import lombok.Data;
import vn.t3h.class2109.dto.valid.PasswordsEqualConstraint;
import vn.t3h.class2109.entities.UserEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@PasswordsEqualConstraint(message = "Mật khẩu không trùng khớp")
public class UserDto {
    Long id;
    @NotBlank(message = "Không được phép rỗng")
    @Size(message = "Nhập ít nhất 4 ký tự", min = 4)
    String username;

    @NotBlank(message = "Không được phép rỗng")
    @Size(message = "Nhập ít nhất 6 ký tự", min = 6)
    String password;
    String email;
    String phone;
    String repassword;
    @NotBlank(message = "Không được phép rỗng")
    String role;

    public UserEntity mapperEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setPhone(phone);
        userEntity.setUsername(username);
        userEntity.setRole(role);
        return userEntity;
    }
}
