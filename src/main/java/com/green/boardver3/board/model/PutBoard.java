package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class PutBoard {
    private long boardId;
    private String title;
    private String contents;
}
