package com.mycompany.jobspringboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mycompany.jobspringboot.domain.CompanyLink;
import com.mycompany.jobspringboot.mapper.CompanyLinkMapper;
import com.mycompany.jobspringboot.utils.ResponseResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companylink")
public class CompanyLinkController {

    @Resource
    private CompanyLinkMapper linkMapper;

    @PostMapping("/authorize")
    public ResponseResult linkAuthorToCompany(@RequestParam String authorName, @RequestParam String companyName) {
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

    @GetMapping("/mycompanies")
    public ResponseResult getMyCompanies(@RequestParam String authorName) {
        QueryWrapper<CompanyLink> wrapper = new QueryWrapper<>();
        wrapper.eq("link_author", authorName).eq("link_verified", true);
        
        List<CompanyLink> links = linkMapper.selectList(wrapper);
        return new ResponseResult(links);
    }
}
