package com.mycompany.jobspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycompany.jobspringboot.domain.Jobs;
import com.mycompany.jobspringboot.service.JobsService;
import com.mycompany.jobspringboot.mapper.JobsMapper;
import com.mycompany.jobspringboot.vo.JobsByCategoryVo;
import com.mycompany.jobspringboot.vo.JobsByCityVo;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author al
* @description 针对表【jobs(岗位详情表)】的数据库操作Service实现
* @createDate 2025-03-14 21:03:13
*/
@Service
public class JobsServiceImpl extends ServiceImpl<JobsMapper, Jobs>
    implements JobsService{
    @Resource
    private JobsMapper jobsMapper;
    /**
     * page query
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<Jobs> getJobsByPage(int pageNum, int pageSize){
        // create page instance
        Page<Jobs> page = new Page<>(pageNum, pageSize);
        // set query condition
        QueryWrapper<Jobs> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id",
                "job_title",
                "category_name",
                "salary",
                "city",
                "company",
                "publish_time"
        );
        queryWrapper.orderByDesc("publish_time");
        // execute query
        Page<Jobs> jobsPage = jobsMapper.selectPage(page, queryWrapper);
        return jobsPage;
    }

    public List<JobsByCategoryVo> countByCategoryName(){
        List<JobsByCategoryVo> jobsByCategoryVos = jobsMapper.countByCategoryName();
        return jobsByCategoryVos;
    }

    public List<JobsByCityVo> countByCity(){
        List<JobsByCityVo> jobsByCityVos = jobsMapper.countByCity();
        return jobsByCityVos;
    }

}




