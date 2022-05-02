package vn.t3h.class2109.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
public class UserDetailCustom extends User {
    private String email;
    private String phone;
    private Long id;

    public UserDetailCustom(String username, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, true, true, true, authorities);
    }
}
