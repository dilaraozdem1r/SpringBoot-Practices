package com.springbootpractise.springbootrestapi.util;

import lombok.Data;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class CustomPage<T> {

    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private Sort sort;
    private int totalPages;
    private long totalElements;

    public CustomPage(Page page, List<T> list){
        this.content=list;
        this.pageNumber=page.getNumber();
        this.pageSize=page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
        this.totalElements=page.getTotalElements();
    }
 }
