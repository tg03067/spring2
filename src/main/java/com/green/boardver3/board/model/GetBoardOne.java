package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class GetBoardOne {
    private long boardId;
    private String title;
    private String contents;
    private long writerId;
    private int hits;
    private String createdAt;
    private String updatedAt;
}
