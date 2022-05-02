package vn.t3h.class2109.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.CategoryDto;
import vn.t3h.class2109.dto.ProductDto;
import vn.t3h.class2109.dto.TableDataDto;
import vn.t3h.class2109.entities.CategoryEntity;
import vn.t3h.class2109.paging.PagingAndSortObject;
import vn.t3h.class2109.repositories.CategoryRepository;
import vn.t3h.class2109.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements TableService {
    @Autowired
    CategoryRepository categoryRepository;

    public boolean saveCategory(CategoryDto categoryDto) {
        StringBuilder sql = new StringBuilder();
        if (categoryDto.getId() == null) {// thêm mới
            sql.append("INSERT INTO category (name, description) VALUES (");
            sql.append("'").append(categoryDto.getName()).append("',");
            sql.append("'").append(categoryDto.getDescription()).append("')");
            return DbUtil.saveDb(sql.toString());
        } else // sửa
            return editCategory(categoryDto);

    }

    public boolean editCategory(CategoryDto categoryDto) {
        if (categoryDto == null || categoryDto.getId() == null || categoryDto.getId() < 0) return false;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE category SET ");
        sql.append(" name='").append(categoryDto.getName()).append("',");
        sql.append(" description='").append(categoryDto.getDescription()).append("'");
        sql.append(" where id = ").append(categoryDto.getId());

        return DbUtil.saveDb(sql.toString());
    }


    public List<CategoryEntity> getAll(){
        return categoryRepository.findAll();
    }
    public void findAll(PagingAndSortObject page){
        page.findAll(categoryRepository);
    }


    CategoryDto convertFromEntityToDto(CategoryEntity entity) {
        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(entity.getId());
//        categoryDto.setName(entity.getName());

//        BeanUtils.copyProperties(entity, categoryDto);
        return categoryDto;
    }
}
