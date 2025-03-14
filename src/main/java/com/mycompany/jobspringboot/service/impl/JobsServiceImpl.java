package com.mycompany.jobspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycompany.jobspringboot.domain.Jobs;
import com.mycompany.jobspringboot.service.JobsService;
import com.mycompany.jobspringboot.mapper.JobsMapper;
import org.springframework.stereotype.Service;

/**
* @author al
* @description 针对表【jobs(岗位详情表)】的数据库操作Service实现
* @createDate 2025-03-14 21:03:13
*/
@Service
public class JobsServiceImpl extends ServiceImpl<JobsMapper, Jobs>
    implements JobsService{

}




