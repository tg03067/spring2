package com.green.boardver3.board;

import com.green.boardver3.board.model.GetBoardList;
import com.green.boardver3.board.model.GetBoardOne;
import com.green.boardver3.board.model.PostBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public int postBoard(PostBoard p){
        return mapper.postBoard(p);
    }
    public List<GetBoardList> getBoardList(){
        return mapper.getBoardList();
    }
    public GetBoardOne getBoardOne(long p){
        return mapper.getBoardOne(p);
    }
}
