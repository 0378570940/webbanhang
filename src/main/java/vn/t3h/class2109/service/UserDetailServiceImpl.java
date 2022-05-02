package vn.t3h.class2109.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.UserDetailCustom;
import vn.t3h.class2109.entities.UserEntity;
import vn.t3h.class2109.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findFirstByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("không tìm thấy user name");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getRole()));

        boolean enabled = userEntity.getStatus().equals(UserService.ACTIVE);
        UserDetailCustom userDetailCustom = new UserDetailCustom(userEntity.getUsername(), userEntity.getPassword(),
           enabled, grantedAuthorities);
        userDetailCustom.setEmail(userEntity.getEmail());
        userDetailCustom.setPhone(userEntity.getPhone());
        userDetailCustom.setId(userEntity.getId());
        return userDetailCustom;

    }
}
