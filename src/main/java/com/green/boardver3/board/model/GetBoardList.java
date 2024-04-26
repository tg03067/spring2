package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class GetBoardList {
    private long boardId;
    private String title;
    private long writerId;
    private String writerNm;
    private int hit;
    private String createdAt;
}
