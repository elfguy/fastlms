package com.zerobase.fastlms.admin.mapper;

import com.zerobase.fastlms.admin.dto.MailTemplateDto;
import com.zerobase.fastlms.admin.model.MailTemplateParam;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MailTemplateMapper {
    
    long selectListCount(MailTemplateParam parameter);
    List<MailTemplateDto> selectList(MailTemplateParam parameter);
    
}
