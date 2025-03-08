package com.mycompany.jobspringboot.service;

import com.mycompany.jobspringboot.domain.JobCategory;

import java.util.List;

public interface JobCategoryService {
    /**
     * get all job categories
     * @return
     */
    List<JobCategory> getAllJobCategory();

    /**
     * create new job category
     * @param jobCategory
     * @return
     */
    int addJobCategory(JobCategory jobCategory);

    /**
     * delete job category
     * @param id
     * @return
     */
    int removeJobCategory(Integer id);

    /**
     * update job category
     * @param jobCategory
     * @return
     */
    int updateJobCategory(JobCategory jobCategory);

}
