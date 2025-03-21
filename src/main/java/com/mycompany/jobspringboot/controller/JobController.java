package com.mycompany.jobspringboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mycompany.jobspringboot.domain.Jobs;
import com.mycompany.jobspringboot.service.JobsService;
import com.mycompany.jobspringboot.utils.ResponseResult;
import com.mycompany.jobspringboot.vo.JobsByCategoryVo;
import com.mycompany.jobspringboot.vo.JobsByCityVo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;@RestController
@RequestMapping("/job")
@Slf4j
@Tag(name = "职位管理", description = "职位数据相关接口")
public class JobController {

    // inject service
    @Resource
    private JobsService jobsService;

    /**
     * get job data by id
     * @return
     */
    @Operation(summary = "根据ID获取职位信息", description = "通过职位ID查询单个职位的详细信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "查询成功",
                    content = @Content(schema = @Schema(implementation = Jobs.class))),
            @ApiResponse(responseCode = "401", description = "没有找到对应ID的职位数据")
    })
    @GetMapping("/v1/{id}")
    public ResponseResult getById(
            @Parameter(description = "职位ID", required = true)
            @PathVariable("id") Integer id) {
        Jobs byId = jobsService.getById(id);
        if (byId != null) {
            return new ResponseResult(byId);
        }
        return new ResponseResult(401, "No data found for this id");
    }

    /**
     * get job data by page
     * @return
     */
    @Operation(summary = "分页获取职位列表", description = "获取职位数据的分页列表，每页显示20条数据")
    @ApiResponse(responseCode = "200", description = "查询成功")
    @GetMapping("/v1/page/{page}")
    public ResponseResult getByPage(
            @Parameter(description = "页码", required = true)
            @PathVariable("page") Integer page) {
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
    @Operation(summary = "按类别统计职位数量", description = "统计各个职位类别的数量分布")
    @ApiResponse(responseCode = "200", description = "统计成功")
    @GetMapping("/v1/category/statistics")
    public ResponseResult getByCategory(){
        List<JobsByCategoryVo> jobsByCategoryVos = jobsService.countByCategoryName();
        return new ResponseResult(jobsByCategoryVos);
    }

    /**
     * count jobs by city
     * @return
     */
    @Operation(summary = "按城市统计职位数量", description = "统计各个城市的职位数量分布")
    @ApiResponse(responseCode = "200", description = "统计成功")
    @GetMapping("/v1/city/statistics")
    public ResponseResult getByCity(){
        List<JobsByCityVo> jobsByCityVos = jobsService.countByCity();
        return new ResponseResult(jobsByCityVos);
    }
}