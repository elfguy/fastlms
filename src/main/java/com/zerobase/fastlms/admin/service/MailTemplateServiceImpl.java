package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.MailTemplateDto;
import com.zerobase.fastlms.admin.entity.MailTemplate;
import com.zerobase.fastlms.admin.mapper.MailTemplateMapper;
import com.zerobase.fastlms.admin.model.MailTemplateInput;
import com.zerobase.fastlms.admin.model.MailTemplateParam;
import com.zerobase.fastlms.admin.repository.MailTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MailTemplateServiceImpl implements MailTemplateService {
    
    private final MailTemplateRepository mailTemplateRepository;
    private final MailTemplateMapper mailTemplateMapper;
    
    @Override
    public boolean add(MailTemplateInput parameter) {

        MailTemplate mailTemplate = MailTemplate.builder()
                .mailTemplateId(parameter.getMailTemplateId())
                .title(parameter.getTitle())
                .contents(parameter.getContents())
                .regId(parameter.getRegId())
                .regDt(LocalDateTime.now())
                .build();
        mailTemplateRepository.save(mailTemplate);
        
        return true;
    }
    
    @Override
    public boolean set(MailTemplateInput parameter) {
    
        Optional<MailTemplate> optionalMailTemplate = mailTemplateRepository.findById(parameter.getMailTemplateId());
        if (!optionalMailTemplate.isPresent()) {
            //수정할 데이터가 없음
            return false;
        }

        MailTemplate mailTemplate = optionalMailTemplate.get();

        mailTemplate.setTitle(parameter.getTitle());
        mailTemplate.setContents(parameter.getContents());
        mailTemplate.setEditId(parameter.getEditId());
        mailTemplate.setEditDt(LocalDateTime.now());

        mailTemplateRepository.save(mailTemplate);
        
        return true;
    }
    
    @Override
    public List<MailTemplateDto> list(MailTemplateParam parameter) {
    
        long totalCount = mailTemplateMapper.selectListCount(parameter);
    
        List<MailTemplateDto> list = mailTemplateMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for(MailTemplateDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
    
        return list;
    }
    
    @Override
    public MailTemplateDto getById(String mailTemplateId) {
        return mailTemplateRepository.findByMailTemplateId(mailTemplateId).map(MailTemplateDto::of).orElse(null);
    }
    
//    @Override
//    public boolean del(String idList) {
//
//        if (idList != null && idList.length() > 0) {
//            String[] ids = idList.split(",");
//            for(String x : ids) {
//                long id = 0L;
//                try {
//                    id = Long.parseLong(x);
//                } catch (Exception e) {
//                }
//
//                if (id > 0) {
//                    courseRepository.deleteById(id);
//                }
//            }
//        }
//
//        return true;
//    }
    
}
