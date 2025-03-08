package com.mycompany.jobspringboot.controller;

import com.mycompany.jobspringboot.domain.JobCategory;
import com.mycompany.jobspringboot.service.JobCategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobCategoryController {

    @Resource
    private JobCategoryService jobCategoryService;

    @GetMapping("/all/category")
    public List<JobCategory> getAllCategory(){
        return jobCategoryService.getAllJobCategory();
    }

    @PostMapping("/add/category")
    public int addCategory(JobCategory jobCategory){
        return jobCategoryService.addJobCategory(jobCategory);
    }

    @PostMapping("/delete/category")
    public int deleteCategory(@RequestParam(value = "id") Integer id){
        return jobCategoryService.removeJobCategory(id);
    }

    @PostMapping("/update/category")
    public int updateCategory(JobCategory jobCategory){
        return jobCategoryService.updateJobCategory(jobCategory);
    }
}
