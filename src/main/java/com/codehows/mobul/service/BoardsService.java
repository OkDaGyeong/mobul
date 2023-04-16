package com.codehows.mobul.service;


import com.codehows.mobul.dto.BoardsFormDTO;
import com.codehows.mobul.entity.Boards;
import com.codehows.mobul.entity.BoardsFile;
import com.codehows.mobul.repository.BoardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardsService {

    @Autowired
    private final BoardsRepository boardsRepository;

    @Autowired
    private final BoardsFileService boardsFileService;

//    @Autowired
//    private final BoardsFileRepository boardsFileRepository;

    public Long saveBoard(BoardsFormDTO boardsFormDTO, List<MultipartFile> fileList) throws Exception{
        // 게시글 등록
        Boards boards = boardsFormDTO.createBoard();
        boardsRepository.save(boards);

        // 이미지 등록
        for(int i=0; i<fileList.size(); i++){
            BoardsFile boardsFile = new BoardsFile();
            boardsFile.setBoards(boards);

            boardsFileService.saveFile(boardsFile, fileList.get(i));
        }

        return boards.getBoardId();
    }

}
