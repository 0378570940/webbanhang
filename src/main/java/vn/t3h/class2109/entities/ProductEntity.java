package vn.t3h.class2109.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity(name = "product")
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "brand", nullable = true, length = 255)
    private String brand;
    @Basic
    @Column(name = "price", nullable = true)
    private Long price;
    @Basic
    @Column(name = "description", nullable = true, length = 500)
    private String description;
    @Basic
    @Column(name = "category", nullable = true)
    private Long category;
    @Basic
    @Column(name = "image", nullable = true, length = 255)
    private String image;

    @Basic
    @Column(name = "create_by", nullable = true, length = 255)
    private Long createBy;

    @ManyToOne(fetch = FetchType.EAGER)
//    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by", referencedColumnName = "id", insertable = false, updatable = false)
    private UserEntity user;

}
