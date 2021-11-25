package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.MailTemplate;
import com.zerobase.fastlms.course.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MailTemplateDto {

    String mailTemplateId;
    String title;
    String contents;
    String regId;
    LocalDateTime regDt;
    String editId;
    LocalDateTime editDt;


    //추가컬럼
    long totalCount;
    long seq;
    
    
    public static MailTemplateDto of(MailTemplate mailTemplate) {
        return MailTemplateDto.builder()
                .mailTemplateId(mailTemplate.getMailTemplateId())
                .title(mailTemplate.getTitle())
                .contents(mailTemplate.getContents())
                .regId(mailTemplate.getRegId())
                .regDt(mailTemplate.getRegDt())
                .editId(mailTemplate.getEditId())
                .editDt(mailTemplate.getEditDt())
                .build();
    }
}
