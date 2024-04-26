package com.green.boardver3.board;

import com.green.boardver3.board.model.GetBoardList;
import com.green.boardver3.board.model.GetBoardOne;
import com.green.boardver3.board.model.PostBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int postBoard(PostBoard p);
    List<GetBoardList> getBoardList();
    GetBoardOne getBoardOne(long p);
}
