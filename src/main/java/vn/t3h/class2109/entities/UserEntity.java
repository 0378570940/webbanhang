package vn.t3h.class2109.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity(name = "user")
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "email", nullable = true, length = 45)
    private String email;
    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    private String phone;
    @Basic
    @Column(name = "role", nullable = true, length = 45)
    private String role;

    @Basic
    @Column(name = "CODE", nullable = true, length = 45)
    private String code;

    @Basic
    @Column(name = "STATUS", nullable = false)
    private Integer status;

}
