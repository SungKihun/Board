package com.example.board.persistence;

import com.example.board.domain.ImageVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ImageMapper {
    @Insert({
            "<script>",
            "INSERT INTO image(mimetype, originalName, data)",
            "VALUES(#{mimetype}, #{originalName}, #{data})",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertBoard(ImageVO imageVO);
}
