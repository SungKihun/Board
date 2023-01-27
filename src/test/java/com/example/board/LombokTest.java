package com.example.board;

import com.example.board.domain.ResultVO;
import org.junit.jupiter.api.Test;

public class LombokTest {
    @Test
    public void ResultTest() {
        ResultVO result = new ResultVO(0, "hone");
        System.out.print(result);
    }
}
