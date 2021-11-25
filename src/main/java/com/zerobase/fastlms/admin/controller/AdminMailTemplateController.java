package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.dto.MailTemplateDto;
import com.zerobase.fastlms.admin.model.MailTemplateParam;
import com.zerobase.fastlms.admin.service.MailTemplateService;
import com.zerobase.fastlms.course.controller.BaseController;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminMailTemplateController extends BaseController {

    private final MailTemplateService mailTemplateService;

    @GetMapping("/admin/mail/template/list.do")
    public String list(Model model, MailTemplateParam parameter){

        parameter.init();
        List<MailTemplateDto> mailTemplateList = mailTemplateService.list(parameter);

        long totalCount = 0;
        if (!CollectionUtils.isEmpty(mailTemplateList)) {
            totalCount = mailTemplateList.get(0).getTotalCount();
        }
        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", mailTemplateList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "admin/mailtemplate/list";
    }

//    @GetMapping(value = {"/admin/mail/template/add.do", "/admin/mail/template/edit.do"})
//    public String add(Model model, HttpServletRequest request
//            , CourseInput parameter) {
//
//        //카테고리 정보를 내려줘야 함.
//        //model.addAttribute("category", categoryService.list());
//
//        boolean editMode = request.getRequestURI().contains("/edit.do");
////        CourseDto detail = new CourseDto();
////
////        if (editMode) {
////            long id = parameter.getId();
////            CourseDto existCourse = courseService.getById(id);
////            if (existCourse == null) {
////                // error 처리
////                model.addAttribute("message", "강좌정보가 존재하지 않습니다.");
////                return "common/error";
////            }
////            detail = existCourse;
////        }
////
////        model.addAttribute("editMode", editMode);
////        model.addAttribute("detail", detail);
//
//        return "admin/mailtemplate/add";
//    }

//    @PostMapping(value = {"/admin/mail/template/add.do", "/admin/mail/template/edit.do"})
//    public String addSubmit(Model model, HttpServletRequest request
//            , CourseInput parameter) {
//
//        boolean editMode = request.getRequestURI().contains("/edit.do");
//
////        if (editMode) {
////            long id = parameter.getId();
////            CourseDto existCourse = courseService.getById(id);
////            if (existCourse == null) {
////                // error 처리
////                model.addAttribute("message", "강좌정보가 존재하지 않습니다.");
////                return "common/error";
////            }
////
////            boolean result = courseService.set(parameter);
////
////        } else {
////            boolean result = courseService.add(parameter);
////        }
//
//        return "redirect:/admin/mail/template/list.do";
//    }

//    @PostMapping("/admin/course/delete.do")
//    public String del(Model model, HttpServletRequest request
//            , CourseInput parameter) {
//
////        boolean result = courseService.del(parameter.getIdList());
//
//        return "redirect:/admin/mail/template/list.do";
//    }

}
