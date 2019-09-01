package com.test.www.service;

import com.test.www.dto.PaginationDTO;
import com.test.www.dto.QuestionDTO;
import com.test.www.mapper.QuestionMapper;
import com.test.www.mapper.UserMapper;
import com.test.www.model.Question;
import com.test.www.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {

        Integer total = questionMapper.total();
        Integer pages = (int) Math.ceil(total / (double) size);
        if (page > pages) {
            page = pages;
        }

        if (page < 1) {
            page = 1;
        }

        Integer start = (page - 1) * size;
        List<Question> questionList = questionMapper.list(start, size);

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questionList) {
            User user = userMapper.findByID(question.getUid());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setData(questionDTOList);
        paginationDTO.setTotal(total);
        paginationDTO.setCurrentPage(page);

        return paginationDTO;
    }

    public PaginationDTO userList(Integer userId, Integer page, Integer size) {

        Integer total = questionMapper.userTotal(userId);

        Integer pages = (int) Math.ceil(total / (double) size);
        if (page > pages) {
            page = pages;
        }

        if (page < 1) {
            page = 1;
        }

        Integer start = (page - 1) * size;
        List<Question> questionList = questionMapper.listByUserId(userId, start, size);

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questionList) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(new User());
            questionDTOList.add(questionDTO);
        }

        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setData(questionDTOList);
        paginationDTO.setTotal(total);
        paginationDTO.setCurrentPage(page);

        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question = questionMapper.findById(id);
        User user = userMapper.findByID(question.getUid());
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setUser(user);

        return questionDTO;
    }

    public void save(Question question) {
        question.setModifiedTime(System.currentTimeMillis());
        if (question.getId() == null) {
            question.setCreateTime(question.getModifiedTime());
            questionMapper.insertQuestion(question);
        } else {
            questionMapper.update(question);
        }
    }
}
