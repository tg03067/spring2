package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
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
    public List<GetBoardList> getBoardList(GetPage p){
        return mapper.getBoardList(p);
    }
    public GetBoardOne getBoardOne(long p){
        GetBoardOne one =mapper.getBoardOne(p);
        if(one != null){
            mapper.patchBoardHits(p);
        }
        return mapper.getBoardOne(p);
    }
    public int putBoard(PutBoard p){
        return mapper.putBoard(p);
    }
    public int delBoard(long p){
        return mapper.delBoard(p);
    }
}
