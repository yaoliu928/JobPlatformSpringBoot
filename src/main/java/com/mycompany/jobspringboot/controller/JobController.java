package com.mycompany.jobspringboot.controller;

import com.mycompany.jobspringboot.domain.Jobs;
import com.mycompany.jobspringboot.service.JobsService;
import com.mycompany.jobspringboot.utils.ResponseResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
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
}
