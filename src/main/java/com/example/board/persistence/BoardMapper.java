package com.example.board.persistence;

import com.example.board.domain.BoardVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert({
            "<script>",
            "INSERT INTO board(title, content)",
            "VALUES(#{title}, #{content})",
            "</script>"
    })
    int insertBoard(BoardVO boardVO);

    @Select({
            "<script>",
            "SELECT * from board",
            "where id = #{id}",
            "</script>"
    })
    BoardVO findOneBoard(int id);

    // 게시판 목록보기 페이징 적용 후
    @Select({
            "<script>",
            "SELECT * from board",
            "order by id desc",
            "<if test='offset != null and pageSize != null'>",
            "LIMIT #{offset}, #{pageSize}",
            "</if>",
            "</script>"
    })
    List<BoardVO> findBoard(Integer offset, Integer pageSize);

    @Select({
            "<script>",
            "SELECT count(*) from board",
            "</script>"
    })
    Integer countBoard();

    @Update({
            "<script>",
            "UPDATE board",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='title != null'>title = #{title},</if>",
            "<if test='content != null'>content = #{content},</if>",
            "</trim>",
            "WHERE id = #{id}",
            "</script>"
    })
    int updateBoard(BoardVO boardVO);

    @Delete({
            "<script>",
            "DELETE FROM board",
            "WHERE id = #{id}",
            "</script>"
    })
    int deleteBoard(int id);
}
