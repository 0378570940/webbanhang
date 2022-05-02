package vn.t3h.class2109.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    Long id;// định danh sản phẩm
    Long price;
    String name;
    String brand;
    String description;
    Long category;
    String image;
}
