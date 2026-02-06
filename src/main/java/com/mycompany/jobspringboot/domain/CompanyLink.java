package com.mycompany.jobspringboot.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("company_link")
@Data
public class CompanyLink {
    @TableField("link_author")
    private String linkAuthor;
    
    @TableField("link_company")
    private String linkCompany;
    
    @TableField("link_verified")
    private Boolean linkVerified;
}
