package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int postBoard(PostBoard p);
    List<GetBoardList> getBoardList(GetPage p);
    GetBoardOne getBoardOne(long p);
    int putBoard(PutBoard p);
    int delBoard(long p);
    int patchBoardHits(long p);
}
