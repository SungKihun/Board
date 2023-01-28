package com.example.board.controller;

import com.example.board.domain.BoardVO;
import com.example.board.domain.ResultVO;
import com.example.board.persistence.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardController {
    private final BoardMapper boardMapper;

    @PostMapping("/board")
    public ResultVO addBoard(@RequestBody BoardVO boardVO) {
        int result = boardMapper.insertBoard(boardVO);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/board/{id}")
    public BoardVO findOne(@PathVariable int id) {
        return boardMapper.findOneBoard(id);
    }

    // 게시판 목록보기 페이징 적용 후
    @GetMapping("/boards")
    public List<BoardVO> findAllBoard(@RequestParam @Nullable Integer pageNumber,
                                      @RequestParam @Nullable Integer pageSize) {
        Integer offset = null;
        if (pageNumber != null && pageSize != null) {
            offset = (pageNumber - 1) * pageSize;
        }
        return boardMapper.findBoard(offset, pageSize);
    }
}
