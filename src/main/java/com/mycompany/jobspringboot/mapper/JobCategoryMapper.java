package com.mycompany.jobspringboot.mapper;

import com.mycompany.jobspringboot.domain.JobCategory;

import java.util.List;

public interface JobCategoryMapper {
    /**
     * Query data
     * @return
     */
    List<JobCategory> allJobCategory();

    /**
     * Add data
     * @param jobCategory
     * @return
     */
    int insertJobCategory(JobCategory jobCategory);

    /**
     * Delete data
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * Update data
     * @param jobCategory
     * @return
     */
     int updateByPrimaryKey(JobCategory jobCategory);
}
