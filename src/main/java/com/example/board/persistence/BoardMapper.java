package com.example.board.persistence;

import com.example.board.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert({"<script>",
            "INSERT INTO board(title, content)",
            "VALUES(#{title}, #{content})",
            "</script>"})
    int insertBoard(BoardVO boardVO);

    @Select({"<script>",
            "SELECT * from board",
            "where id = #{id}",
            "</script>"})
    BoardVO findOneBoard(int id);

    // 게시판 목록보기 페이징 적용 후
    @Select({"<script>",
            "SELECT * from board",
            "order by id desc",
            "<if test='offset != null and pageSize != null'>",
            "LIMIT #{offset}, #{pageSize}",
            "</if>",
            "</script>"})
    List<BoardVO> findBoard(Integer offset, Integer pageSize);

    @Select({"<script>",
            "SELECT count(*) from board",
            "</script>"})
    Integer countBoard();
}
