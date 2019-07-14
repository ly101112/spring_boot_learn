package com.test.www.model;

import lombok.Data;

@Data
public class Question {
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
}
