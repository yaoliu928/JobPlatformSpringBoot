package com.mycompany.jobspringboot.mapper;

import com.mycompany.jobspringboot.domain.Jobs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mycompany.jobspringboot.vo.JobsByCategoryVo;

import java.util.List;

/**
* @author al
* @description 针对表【jobs(岗位详情表)】的数据库操作Mapper
* @createDate 2025-03-14 21:03:13
* @Entity com.mycompany.jobspringboot.domain.Jobs
*/
public interface JobsMapper extends BaseMapper<Jobs> {

    List<JobsByCategoryVo> countByCategoryName();

}




