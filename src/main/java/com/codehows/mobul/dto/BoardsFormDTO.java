package com.codehows.mobul.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class BoardsFormDTO {
    private Long boardId;        // 게시판 번호

    private String boardTitle;     //게시판 제목

    private String boardContent;     // 게시판 내용

    private String boardWriter;     // 게시판 작성자

    private LocalDateTime boardDate;       // 작성한 시간

    private LocalDateTime boardDateUpdate;  // 수정한 시간

    private String boardTag;        // 게시판 해시태그




    // ----혜영 : 확인 후 삭제

//    private int boardView;          // 게시판 조회수

//    private int boardLike;          // 게시판 좋아요 수



}
