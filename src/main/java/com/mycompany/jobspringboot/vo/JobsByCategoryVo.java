package com.mycompany.jobspringboot.vo;

import lombok.Data;

@Data
public class JobsByCategoryVo {
    private String categoryName;
    private String categoryDesc;
    private Integer quantity;
}
