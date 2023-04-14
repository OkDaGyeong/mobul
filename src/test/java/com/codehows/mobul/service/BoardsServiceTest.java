package com.codehows.mobul.service;


import com.codehows.mobul.dto.BoardsFormDTO;

import com.codehows.mobul.entity.Boards;
import com.codehows.mobul.entity.BoardsFile;
import com.codehows.mobul.repository.BoardsFileRepository;
import com.codehows.mobul.repository.BoardsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
public class BoardsServiceTest {

    @Autowired
    BoardsService boardsService;

    @Autowired
    BoardsRepository boardsRepository;

    @Autowired
    BoardsFileRepository boardsFileRepository;

    List<MultipartFile> createMultipartFiles() throws Exception{
        List<MultipartFile> fileList = new ArrayList<>();

        for(int i=0; i<5; i++){
            String path = "C:/mobul/board/";
            String fileName = "image" + i + ".jpg";
            MockMultipartFile multipartFile = new MockMultipartFile(path, fileName, "image/jpg", new byte[]{1,2,3,4});
            fileList.add(multipartFile);
        }
        return fileList;
    }

    @Test
    @DisplayName("게시글 등록 테스트")
    @WithMockUser(username = "admin", roles ="ADMIN")
    void saveBoards() throws Exception{
        BoardsFormDTO boardsFormDTO = new BoardsFormDTO();
        boardsFormDTO.setBoardTitle("테스트제목");
        boardsFormDTO.setBoardContent("테스트내용");

        List<MultipartFile> fileList = createMultipartFiles();
        Long boardId = boardsService.saveFile(boardsFormDTO, fileList);
        System.out.print(boardId);
//        List<BoardsFile> boardsFileList =
//                            boardsFileRepository.findByBoardIdOrderByIdAsc(boardId);
//        Boards boards = boardsRepository.findById(boardId)
//                        .orElseThrow(EntityNotFoundException::new);
//
//        assertEquals(boardsFormDTO.getBoardTitle(), boards.getBoardTitle());
//        assertEquals(boardsFormDTO.getBoardContent(), boards.getBoardContent());



    }


//    @Test
//    @DisplayName("게시글 등록 테스트")
//    @WithMockUser(username = "admin", roles ="ADMIN")
//    void saveItem() throws Exception{
//        Users user = new Users();
//        user.setUserId("test");
//        user.setUserPassword("test");
//        user.setUserPhone("000000");
//        usersRepository.save(user);
//
//
//
//        BoardsFormDTO boardsFormDTO = new BoardsFormDTO();
//        boardsFormDTO.setBoardTitle("테스트제목");
//        boardsFormDTO.setBoardContent("테스트내용");
//        boardsFormDTO.setBoardWriter("테스트 작성자");         // boards 테이블의 boards_id
//        boardsFormDTO.setBoardTag("테스트 해시태그");
//
//        Long boardId = boardsService.saveBoards(boardsFormDTO, multipartFileList);
//
//        Boards boards = boardsRepository.findById(boardId)
//                        .orElseThrow(EntityNotFoundException::new);
//
//        assertEquals(boardsFormDTO.getBoardTitle(), boards.getBoardTitle());
//        assertEquals(boardsFormDTO.getBoardContent(), boards.getBoardContent());
//        assertEquals(boardsFormDTO.getBoardWriter(), boards.getBoardWriter());
//        assertEquals(boardsFormDTO.getBoardTag(), boards.getBoardTag());
//
//
//    }
}
