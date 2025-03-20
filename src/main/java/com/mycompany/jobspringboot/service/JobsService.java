package com.mycompany.jobspringboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mycompany.jobspringboot.domain.Jobs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mycompany.jobspringboot.vo.JobsByCategoryVo;

import java.util.List;

/**
* @author al
* @description 针对表【jobs(岗位详情表)】的数据库操作Service
* @createDate 2025-03-14 21:03:13
*/
public interface JobsService extends IService<Jobs> {

    /**
     * page query
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<Jobs> getJobsByPage(int pageNum, int pageSize);

    List<JobsByCategoryVo> countByCategoryName();
}
