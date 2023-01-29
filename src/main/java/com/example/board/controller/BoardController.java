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
    public static final String SUCCESS = "success";
    
    @PostMapping("/board")
    public ResultVO addBoard(@RequestBody BoardVO boardVO) {
        int result = boardMapper.insertBoard(boardVO);
        if (result > 0) {
            return new ResultVO(0, SUCCESS);
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

    @GetMapping("/board/count")
    public Integer countBoard() {
        return boardMapper.countBoard();
    }

    @PutMapping("/board")
    public ResultVO modifyBoard(@RequestBody BoardVO boardVO) {
        int result = boardMapper.updateBoard(boardVO);
        if (result > 0) {
            return new ResultVO(0, SUCCESS);
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("/board")
    public ResultVO removeBoard(@RequestParam int id) {
        int result = boardMapper.deleteBoard(id);
        if (result > 0) {
            return new ResultVO(0, SUCCESS);
        } else {
            return new ResultVO(100, "fail");
        }
    }
}
