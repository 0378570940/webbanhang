package vn.t3h.class2109.paging;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PagingAndSortParam {
    public String path();
}
