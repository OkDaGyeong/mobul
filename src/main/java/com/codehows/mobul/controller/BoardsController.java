package com.codehows.mobul.controller;

import com.codehows.mobul.dto.BoardsFormDTO;
import com.codehows.mobul.repository.UsersRepository;
import com.codehows.mobul.service.BoardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


//board 뒤에 붙게 대표 주소 /board 입력
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardsController {
    @Autowired
    private final BoardsService boardsService;

    @Autowired
    private final UsersRepository usersRepository;



    //경원--
    @GetMapping("/comment")
    public String commentForm(){return "boards/comment";}


    //    상세 페이지-댓글페이지
//    @GetMapping(value="/comment/{}")
//    public String commentForm(Model model, @PathVariable("boardId") Long boardId){
//        BoardsDTO boardsDTO = new BoardsDTO();
//        boardsDTO.setBoardId(1234);
//        model.addAttribute("boardsDto",boardsDTO);
//        return "boards/comment";
//    }


    // 혜영--   게시글 작성페이지
    @GetMapping("/writer")     // writerForm -> boardWriteForm
    public String writerForm(Model model){
        model.addAttribute("boardsFormDto", new BoardsFormDTO());

        return  "boards/writer";
    }


    //     게시물 등록
    @PostMapping("/writer")
    public String boardsWrite(@Valid BoardsFormDTO boardsFormDTO, BindingResult bindingResult, Model model,
                              @RequestParam("boardsFile") List<MultipartFile> fileList){
        if(bindingResult.hasErrors()){ return "/boards/writer"; }

        try{
            boardsService.saveBoard(boardsFormDTO, fileList);
        } catch (Exception e){
            model.addAttribute("errorMessage", "파일 등록 중 에러가 발생하였습니다");
            return "/boards/writer";
        }


        return "redirect:/";
    }









    // 상세페이지 - 조회
//    @RequestMapping(value="/getdetail")
//    @ResponseBody
//    public BoardsDTO getDetail(BoardsDTO boardsDTO, HttpServletRequest request, HttpServletResponse response) throws Exception{
//        BoardsDTO boardsDTO = boardsService.getBoardDetail(BoardsDTO);
//        return boardsDTO;
//    }
//








}
