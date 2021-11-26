package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.MailTemplate;
import com.zerobase.fastlms.course.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

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

    /**
     * 메일에 약속된 내용을 변경해 준다.
     */
    public void setContents(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()){
            this.contents = this.contents.replace("{" + entry.getKey() + "}", entry.getValue());
        }
    }
}
