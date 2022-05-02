package vn.t3h.class2109.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.dto.UserDetailCustom;
import vn.t3h.class2109.entities.ProductEntity;
import vn.t3h.class2109.paging.PagingAndSortObject;
import vn.t3h.class2109.repositories.ProductRepository;
import vn.t3h.class2109.utils.DbUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service// đánh dấu service(bean)
public class ProductService implements TableService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean delete(Long id) {
        return DbUtil.delete("product", id, jdbcTemplate);
    }

    public boolean saveProduct(ProductDto productDto) {

        if (productDto.getId() == null) {// thêm mới
            ProductEntity productEntity = new ProductEntity();
            BeanUtils.copyProperties(productDto, productEntity);
            // Lấys thông tin user đăng nhập
            productEntity.setCreateBy(((UserDetailCustom)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
//            productEntity.setUser();
            productRepository.save(productEntity);
            return true;
        } else // sửa
            return editProduct(productDto);

    }

    public boolean editProduct(ProductDto productDto) {
        if (productDto == null || productDto.getId() == null || productDto.getId() < 0) return false;
        jdbcTemplate.update(
                "UPDATE product set name = ?, brand =?, price =?, category =?, description =?, image =? where id = ? " +
                        "VALUES (?, ?, ?, ?, ?, ?)", productDto.getName(), productDto.getBrand(),
                productDto.getPrice(), productDto.getCategory(), productDto.getDescription(), productDto.getImage(), productDto.getId());
        return true;
    }

    public ProductDto detail(Long id) throws SQLException {
        String query = "SELECT * FROM product WHERE ID = ?";
        ProductDto productDto = jdbcTemplate.queryForObject(
                query, new Object[]{id}, new RowMapper<ProductDto>() {
                    @Override
                    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ProductDto p = new ProductDto();
                        String name = rs.getString(2);
                        String brand = rs.getString(3);
                        long price = rs.getLong(4);
                        String description = rs.getString(5);
                        long category = rs.getLong(6);
                        String image = rs.getString(7);
                        p = new ProductDto(id, price, name, brand, description, category, image);
                        return p;
                    }
                });
        ///////////

        return productDto;
    }

    public void findAll(PagingAndSortObject page) {
        page.findAll(productRepository);
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}
