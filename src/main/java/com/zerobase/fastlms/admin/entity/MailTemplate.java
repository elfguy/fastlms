package com.zerobase.fastlms.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class MailTemplate {
    @Id
    private String mailTemplateId;

    private String title;
    private String contents;
    private String regId;
    private LocalDateTime regDt;
    private String editId;
    private LocalDateTime editDt;
}
