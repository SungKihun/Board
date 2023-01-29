package com.example.board.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CommentVO {
    private Integer id;
    private String content;
    private String created;
    private String updated;
    private Integer boardId;
}
