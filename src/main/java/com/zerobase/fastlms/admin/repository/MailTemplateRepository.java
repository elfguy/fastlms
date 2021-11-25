package com.zerobase.fastlms.admin.repository;

import com.zerobase.fastlms.admin.entity.MailTemplate;
import com.zerobase.fastlms.course.entity.Course;
import com.zerobase.fastlms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MailTemplateRepository extends JpaRepository<MailTemplate, String> {

    Optional<MailTemplate> findByMailTemplateId(String mailTemplateId);

}
