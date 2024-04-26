package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
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
        List<GetBoardList> result = service.getBoardList(p);

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
    @PutMapping
    public ResultDto<Integer> putBoard(@RequestBody PutBoard p){
        int result = service.putBoard(p);

        return ResultDto.<Integer>builder().statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @DeleteMapping
    public ResultDto<Integer> delBoard(@RequestParam(name = "board_id") long p){
        int result = service.delBoard(p);
        return ResultDto.<Integer>builder().statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
}
