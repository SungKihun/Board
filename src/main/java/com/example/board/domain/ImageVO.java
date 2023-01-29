package com.example.board.domain;

import lombok.Data;

@Data
public class ImageVO {
    private Integer id;
    private String mimetype;
    private String originalName;
    private byte[] data;
    private String created;
}
