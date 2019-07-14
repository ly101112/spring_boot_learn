package com.test.www.controller;

import com.test.www.dto.PaginationDTO;
import com.test.www.model.User;
import com.test.www.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonalController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/personal/{method}/{action}")
    public String myQuestionList(
            @PathVariable(name = "method") String method,
            @PathVariable(name = "action") String action,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "5") Integer size,
            HttpServletRequest request,
            Model model) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "no login");
            return "redirect:/";
        }

        String sectionName = "问题列表";
        switch (method + action) {
            case "questionlist":
                break;
            case "questionrepies":
                sectionName = "最新回复";
                break;
        }

        PaginationDTO paginationDTO = questionService.userList(user.getId(), page, size);

        model.addAttribute("dataList", paginationDTO);
        model.addAttribute("method", method);
        model.addAttribute("action", action);
        model.addAttribute("sectionName", sectionName);

        return "personal/" + method;
    }
}
