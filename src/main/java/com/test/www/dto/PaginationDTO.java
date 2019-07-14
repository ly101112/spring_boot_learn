package com.test.www.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> data;
    private Integer currentPage;
    private Integer total;
}
