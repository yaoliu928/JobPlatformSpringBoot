package com.mycompany.jobspringboot.service;

import com.mycompany.jobspringboot.domain.JobCategory;
import com.mycompany.jobspringboot.mapper.JobCategoryMapper;
import com.mycompany.jobspringboot.utils.ResponseResult;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Resource
    private JobCategoryMapper jobCategoryMapper;

    @Override
    public ResponseResult getAllJobCategory() {
        return new ResponseResult(jobCategoryMapper.allJobCategory());
    }

    /**
     * Create job category
     * @param jobCategory
     * @return
     */
    @Override
    public int addJobCategory(JobCategory jobCategory) {
        int result = jobCategoryMapper.insertJobCategory(jobCategory);
        if (result >0) {
            // if insert successfully, return primary key
            result = jobCategory.getId();
        }
        return result;
    }

    /**
     * Delete job category
     * @param id
     * @return
     */
    @Override
    public int removeJobCategory(Integer id) {
        return jobCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * Update job category
     * @param jobCategory
     * @return
     */
    @Override
    public int updateJobCategory(JobCategory jobCategory) {
        return jobCategoryMapper.updateByPrimaryKey(jobCategory);
    }
}
