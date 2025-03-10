package com.mycompany.jobspringboot.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data //generate getter, setter, toString method
@NoArgsConstructor //generate constructor without argument
@AllArgsConstructor //generate constructor with argument
public class JobCategory {
    private int id;
    @NotBlank(message = "Category name cannot be empty")
    @Length(min = 2, max = 20, message = "Category name length must be between 2 and 20")
    private String category_name;
    private String category_desc;
}
