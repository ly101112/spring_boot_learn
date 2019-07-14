package com.test.www.dto;

import com.test.www.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long createTime;
    private Long modifiedTime;
    private Integer uid;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
