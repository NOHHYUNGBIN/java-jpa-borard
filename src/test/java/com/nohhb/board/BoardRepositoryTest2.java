//package com.nohhb.board;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class BoardRepositoryTest2 {
//    @Autowired
//    private BoardRepository boardRepository;
//
//    // 테스트 할때마다 테스트 코드 실행 직전 자동으로 데이터 입력
//    @BeforeEach
//    public void testData() {
//        for (int i = 1; i <=100; i++) {
//            Board board = new Board();
//            board.setBno((long) i);
//            board.setTitle("title" + i);
//            board.setContent("content" + i);
//            board.setWriter("writer" + (i % 5)); // writer 0~4
//            board.setViewCnt((long) (Math.random()*100)); // 0~99
//            board.setInDate(new Date());
//            board.setUpDate(new Date());
//            boardRepository.save(board);
//        }
//    }
//    @Test
//    public void deleteTest() {
//        assertTrue(boardRepository.deleteByWriter("writer1") == 20);
//        List<Board> list = boardRepository.findByWriter("writer1");
//        assertTrue(list.size() == 0);
//    }
//
//    @Test
//    public void findTest(){
//        List<Board> list = boardRepository.findByWriter("writer1");
//        assertTrue(list.size() == 20);
//        list.forEach(System.out::println);
//    }
//    @Test
//    public void countTest() {
//        assertTrue(boardRepository.countAllByWriter("writer1") == 20);
//    }
//}