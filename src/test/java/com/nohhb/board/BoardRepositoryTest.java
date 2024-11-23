package com.nohhb.board;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    @Order(4)
    // delete 테스트
    public void deleteTest() {
        boardRepository.deleteById(1L);

        Board board = boardRepository.findById(1L).orElse(null);
        assertTrue(board == null);
    }

    @Test
    @Order(3)
    // update 테스트
    public void updateTest(){
        Board board = boardRepository.findById(1L).orElse(null);
        assertTrue(board != null);

        board.setTitle("modified Title");
        boardRepository.save(board);

        //못찾으면 새로운 board객체생성
        Board board2 = boardRepository.findById(1L).orElse(new Board());
        System.out.println("board = " + board);
        System.out.println("board2 = " + board2);

        assertTrue(board.getTitle().equals(board2.getTitle()));
    }
    @Test
    @Order(2)
    // select 테스트
    public void selectTest() {
//        Board board = boardRepository.findById(1L).get(); // 값이 없으면 예외가 발생함
        Board board = boardRepository.findById(1L).orElse(null); // 값이 없을 때 널 반환
        System.out.println("board = " + board);
        assertTrue(board != null);
    }
    @Test
    @Order(1)
    // insert 테스트
    public void insertTest() {
        Board board = new Board();
        board.setBno(1L);
        board.setTitle("test");
        board.setContent("this is test");
        board.setWriter("nohhb");
        board.setInDate(new Date());
        board.setUpDate(new Date());
        board.setViewCnt(0L);
        boardRepository.save(board);
    }
}