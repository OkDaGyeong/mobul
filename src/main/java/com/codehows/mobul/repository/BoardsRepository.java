package com.codehows.mobul.repository;

import com.codehows.mobul.dto.BoardsFormDTO;
import com.codehows.mobul.entity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardsRepository extends JpaRepository<Boards, Long> {

    Boards save(Boards boards);

    // BoardForm 객체를 매개변수로 받아서 해당 게시글의 상세 내용을 BoardDto 객체에 담아서 반환
//    BoardsFormDTO boardsFormDto = new BoardsFormDTO();
//    boardsFormDto.setBoard_num();


    // 게시글 조회
//    Boards findByBoardTitle(String boardTitle);
//    Boards findByBoardId(Long boardId);
}
