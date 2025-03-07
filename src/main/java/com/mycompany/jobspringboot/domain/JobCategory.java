package com.mycompany.jobspringboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //generate getter, setter, toString method
@NoArgsConstructor //generate constructor without argument
@AllArgsConstructor //generate constructor with argument
public class JobCategory {
    private int id;
    private String category_name;
    private String category_desc;
}
