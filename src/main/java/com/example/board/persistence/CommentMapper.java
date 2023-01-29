package com.example.board.persistence;

import com.example.board.domain.CommentVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert({
            "<script>",
            "INSERT INTO comment(content, boardId)",
            "VALUES(#{content}, #{boardId})",
            "</script>"
    })
    void insertComment(CommentVO commentVO);

    @Select({
            "<script>",
            "SELECT * from comment",
            "where id = #{id}",
            "</script>"
    })
    CommentVO findOneComment(int id);

    @Select({
            "<script>",
            "SELECT * from comment",
            "order by id desc",
            "</script>"
    })
    List<CommentVO> findComment(int boardId);

    @Update({
            "<script>",
            "UPDATE comment",
            "set content = #{content}",
            "WHERE id = #{id}",
            "</script>"
    })
    int updateComment(CommentVO commentVO);

    @Delete({
            "<script>",
            "DELETE FROM comment",
            "WHERE id = #{id}",
            "</script>"
    })
    int deleteComment(int id);
}
