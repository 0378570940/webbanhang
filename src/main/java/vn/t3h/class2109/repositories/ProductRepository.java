package vn.t3h.class2109.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.class2109.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
//    // Cách 1 lấy tất cả sản phẩm theo tên
//    List<ProductEntity> findAllByName(String name);
//
//    // cách thứ 2
//    @Query("select * from ProductEntity p where p.name = ?1 ")
//    List<ProductEntity> getAllByName(String name);
//
//    // cách 3
//    @Query(value = "SELECT * FROM product p where p.name = ?1", nativeQuery = true)
//    List<ProductEntity> getAllByName2(String name);

//JPA -> HHerbernate -> Spring Dât JPA

}
