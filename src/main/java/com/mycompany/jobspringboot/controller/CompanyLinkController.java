package com.mycompany.jobspringboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mycompany.jobspringboot.domain.CompanyLink;
import com.mycompany.jobspringboot.mapper.CompanyLinkMapper;
import com.mycompany.jobspringboot.utils.ResponseResult;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companylink")
@Validated
public class CompanyLinkController {

    @Resource
    private CompanyLinkMapper linkMapper;

    @PostMapping("/authorize")
    public ResponseResult linkAuthorToCompany(
            @RequestParam @NotBlank(message = "作者名称不能为空") @Size(max = 100, message = "作者名称长度不能超过100") String authorName,
            @RequestParam @NotBlank(message = "公司名称不能为空") @Size(max = 200, message = "公司名称长度不能超过200") String companyName) {
        
        QueryWrapper<CompanyLink> wrapper = new QueryWrapper<>();
        wrapper.eq("link_author", authorName).eq("link_company", companyName);
        
        CompanyLink existing = linkMapper.selectOne(wrapper);
        if (existing != null) {
            return new ResponseResult(400, "链接已存在");
        }
        
        CompanyLink newLink = new CompanyLink();
        newLink.setLinkAuthor(authorName);
        newLink.setLinkCompany(companyName);
        newLink.setLinkVerified(true);
        
        linkMapper.insert(newLink);
        return new ResponseResult("授权成功");
    }

    // TODO: Add authentication check when auth system is implemented
    @GetMapping("/mycompanies")
    public ResponseResult getMyCompanies(
            @RequestParam @NotBlank(message = "作者名称不能为空") @Size(max = 100, message = "作者名称长度不能超过100") String authorName) {
        
        QueryWrapper<CompanyLink> wrapper = new QueryWrapper<>();
        wrapper.eq("link_author", authorName).eq("link_verified", true);
        
        List<CompanyLink> links = linkMapper.selectList(wrapper);
        return new ResponseResult(links);
    }
}
