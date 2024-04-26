package com.green.boardver3.board;

import com.green.boardver3.board.model.GetBoardList;
import com.green.boardver3.board.model.GetBoardOne;
import com.green.boardver3.board.model.GetPage;
import com.green.boardver3.board.model.PostBoard;
import com.green.boardver3.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService service;

    @PostMapping
    public ResultDto<Integer> postBoard(@RequestBody PostBoard p){
        int result = service.postBoard(p);

        return ResultDto.<Integer>builder().statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }
    @GetMapping
    public ResultDto<List<GetBoardList>> getBoardList(@ModelAttribute GetPage p){
        List<GetBoardList> result = service.getBoardList();

        return ResultDto.<List<GetBoardList>>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @GetMapping("board_id")
    public ResultDto<GetBoardOne> getBoardOne(@PathVariable(name = "board_id") long p){
        GetBoardOne one = service.getBoardOne(p);

        return ResultDto.<GetBoardOne>builder().statusCode(HttpStatus.OK).
                resultMsg(one == null ? "내용을 찾을 수 없습니다." : HttpStatus.OK.toString()).
                resultData(one).build();
    }
}
