package vn.t3h.class2109.service;

import vn.t3h.class2109.dto.TableDataDto;
import vn.t3h.class2109.paging.PagingAndSortObject;

public interface TableService {

    public void findAll(PagingAndSortObject page);
}
