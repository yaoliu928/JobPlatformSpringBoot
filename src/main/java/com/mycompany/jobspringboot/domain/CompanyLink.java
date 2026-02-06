package com.mycompany.jobspringboot.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("company_link")
@Data
public class CompanyLink {
    @TableId("link_author")
    @TableField("link_author")
    private String linkAuthor;
    
    @TableId("link_company")
    @TableField("link_company")
    private String linkCompany;
    
    @TableField("link_verified")
    private Boolean linkVerified;
}
