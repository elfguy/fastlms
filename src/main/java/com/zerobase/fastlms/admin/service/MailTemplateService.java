package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.MailTemplateDto;
import com.zerobase.fastlms.admin.model.MailTemplateInput;
import com.zerobase.fastlms.admin.model.MailTemplateParam;

import java.util.List;

public interface MailTemplateService {
    
    
    /**
     * 메일 템플릿 등록
     */
    boolean add(MailTemplateInput parameter);
    
    /**
     * 메일 템플릿 수정
     */
    boolean set(MailTemplateInput parameter);
    
    /**
     * 메일 템플릿 목록
     */
    List<MailTemplateDto> list(MailTemplateParam parameter);
    
    /**
     * 메일 템플릿 상세정보
     */
    MailTemplateDto getById(String mailTemplateId);
    
    /**
     * 메일 템플릿 삭제
     */
    boolean del(String idList);
}
