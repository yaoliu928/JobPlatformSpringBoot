package com.mycompany.jobspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mycompany.jobspringboot.domain.CompanyLink;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyLinkMapper extends BaseMapper<CompanyLink> {
}
