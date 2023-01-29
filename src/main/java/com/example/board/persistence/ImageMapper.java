package com.example.board.persistence;

import com.example.board.domain.ImageVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ImageMapper {
    @Insert({
            "<script>",
            "INSERT INTO image(mimetype, originalName, data)",
            "VALUES(#{mimetype}, #{originalName}, #{data})",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBoard(ImageVO imageVO);

    @Select({
            "<script>",
            "SELECT * from image",
            "where id = #{id}",
            "</script>"
    })
    ImageVO findOneImage(int id);
}
