package com.zerobase.fastlms.admin.entity;

/**
 * 메일 템플릿 키는 DB에 저장된 내용과 약속된 텍스트로 사용해야 하므로 해당 인터페이스에 약속을 정해서 사용한다.
 */
public interface MailTemplateKey {

    //회원가입 메일
    String MEMBER_REGISTER = "MEMBER_REGISTER";

    //비밀번호 초기화 메일
    String RESET_PASSWORD = "RESET_PASSWORD";

}
