package com.codehows.mobul.repository;

import com.codehows.mobul.dto.UsersDTO;
import com.codehows.mobul.entity.Boards;
import com.codehows.mobul.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardsRepositoryTest {


    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BoardsRepository boardsRepository;

    @Test
    public void InsertDummies() {
        Users users = new Users();
        // test 유저 생성
        users.setUserId("test");

        //테스트 케이스에 users 생성
        usersRepository.save(users);
        Users user = usersRepository.findByUserId("test"); // UsersRepository 에 메서드 추상 메서드 작성


        IntStream.rangeClosed(1, 10).forEach(i -> {
            Boards boards = new Boards();
            boards.setBoardTitle("test" + i);
            boards.setUsers(user);

            //create
            boardsRepository.save(boards);
        });
    }

}