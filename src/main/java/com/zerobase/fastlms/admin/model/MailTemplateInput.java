package com.zerobase.fastlms.admin.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MailTemplateInput {

    String mailTemplateId;
    String title;
    String contents;
    String regId;
    String editId;

}
