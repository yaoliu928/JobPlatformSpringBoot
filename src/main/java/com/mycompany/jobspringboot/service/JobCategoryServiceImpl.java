package com.mycompany.jobspringboot.service;

import com.mycompany.jobspringboot.domain.JobCategory;
import com.mycompany.jobspringboot.mapper.JobCategoryMapper;
import com.mycompany.jobspringboot.utils.ResponseResult;
import com.mycompany.jobspringboot.utils.enums.ResultCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseResult addJobCategory(JobCategory jobCategory) {
        int result = jobCategoryMapper.insertJobCategory(jobCategory);
        Map<String, Integer> idMap = new HashMap<>();
        if (result >0) {
            idMap.put("id", jobCategory.getId());
            return new ResponseResult(idMap);
        }
        return new ResponseResult(ResultCodeEnum.SERVER_ERROR);
    }

    /**
     * Delete job category
     * @param id
     * @return
     */
    @Override
    public ResponseResult removeJobCategory(Integer id) {
        int result = jobCategoryMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return new ResponseResult();
        }
        return new ResponseResult(ResultCodeEnum.DB_ERROR);
    }

    /**
     * Update job category
     * @param jobCategory
     * @return
     */
    @Override
    public ResponseResult updateJobCategory(JobCategory jobCategory) {
        int result = jobCategoryMapper.updateByPrimaryKey(jobCategory);
        if (result > 0) {
            return new ResponseResult();
        }
        return new ResponseResult(ResultCodeEnum.DB_ERROR);
    }
}
