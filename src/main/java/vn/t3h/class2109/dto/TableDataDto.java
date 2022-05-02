package vn.t3h.class2109.dto;

import lombok.Data;

@Data
public class TableDataDto {
    Object data;
    Integer page;
    Integer perpage;
    Integer total;// tổng số phần tử
    Integer totalPage;

}
