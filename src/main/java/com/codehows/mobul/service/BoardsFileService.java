package com.codehows.mobul.service;


import com.codehows.mobul.entity.BoardsFile;
import com.codehows.mobul.repository.BoardsFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.transaction.Transactional;
@Service
@Transactional
@RequiredArgsConstructor
public class BoardsFileService {

    @Value("${uploadPath}")
    private String filePath;

    private final BoardsFileRepository boardsFileRepository;

    private final FileService fileService;

    public void saveFile(BoardsFile boardsfile, MultipartFile multipartFile) throws Exception{
        String fileOriName = multipartFile.getOriginalFilename();
        String fileName = "";
        String fileUrl = "";

        // 파일 업로드
        if(!StringUtils.isEmpty(fileOriName)){
            fileName = fileService.uploadFile(filePath, fileOriName, multipartFile.getBytes());
            fileUrl = "/images/board/" + fileName;             // "/images/board/" 경로 확인
        }

        // 상품 이미지 정보 저장
        boardsfile.updateFile(fileOriName, fileName, fileUrl);
        boardsFileRepository.save(boardsfile);
    }


}