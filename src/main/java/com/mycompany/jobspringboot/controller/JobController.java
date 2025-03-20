package com.mycompany.jobspringboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mycompany.jobspringboot.domain.Jobs;
import com.mycompany.jobspringboot.service.JobsService;
import com.mycompany.jobspringboot.utils.ResponseResult;
import com.mycompany.jobspringboot.vo.JobsByCategoryVo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {

    // inject service
    @Resource
    private JobsService jobsService;

    /**
     * get job data by id
     * @return
     */
    @GetMapping("/v1/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        Jobs byId = jobsService.getById(id);
        if (byId != null) {
            return  new ResponseResult(byId);
        }
        return new ResponseResult(401,"No data found for this id");
    }

    /**
     * get job data by page
     * @return
     */
    @GetMapping("/v1/page/{page}")
    public ResponseResult getByPage(@PathVariable("page") Integer page) {
        Integer pageSize = 20;
        IPage<Jobs> jobsByPage = jobsService.getJobsByPage(page, pageSize);

        log.info("total lines: {}", jobsByPage.getTotal());
        log.info("total pages: {}", jobsByPage.getPages());
        log.info("current page: {}", jobsByPage.getCurrent());

        return new ResponseResult(jobsByPage);
    }

    /**
     * count jobs by category
     * @return
     */
    @GetMapping("/v1/category/statistics")
    public ResponseResult getByCategory(){
        List<JobsByCategoryVo> jobsByCategoryVos = jobsService.countByCategoryName();
        return new ResponseResult(jobsByCategoryVos);
    }
}
