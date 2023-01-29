package com.example.board.controller;

import com.example.board.domain.ImageVO;
import com.example.board.persistence.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageMapper imageMapper;

    @PostMapping("/upload")
    public Integer handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        ImageVO imageVO = new ImageVO();
        imageVO.setMimetype(file.getContentType());
        imageVO.setOriginalName(file.getOriginalFilename());
        imageVO.setData(file.getBytes());
        imageMapper.insertBoard(imageVO);

        return imageVO.getId();
    }
}
