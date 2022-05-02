package vn.t3h.class2109.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.class2109.entities.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findFirstByUsername(String username);

    List<UserEntity> findAllByEmail(String email);

    UserEntity findFirstByCode(String code);
}
