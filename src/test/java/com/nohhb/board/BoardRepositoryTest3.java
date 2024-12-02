//package com.nohhb.board;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class BoardRepositoryTest3 {
//
//    @Autowired
//    public EntityManager em;
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
//    @DisplayName("@Query로 네이티브 쿼리(SQL)작성 테스트")
//    public void queryAnnoTest5() {
//        List<Object[]> list = boardRepository.findAllBoardBySQL2();
//        list.stream() // 리스트를 stream으로 변환
//                .map(arr -> Arrays.toString(arr)) // arr을 String으로 변환
//                .forEach(System.out::println);
//        assertTrue(list.size() == 100);
//    }
//    @Test
//    @DisplayName("@Query로 네이티브 쿼리(SQL)작성 테스트")
//    public void queryAnnoTest4() {
//        List<Board> allBoardBySQL = boardRepository.findAllBoardBySQL();
//        allBoardBySQL.forEach(System.out::println);
//        assertTrue(allBoardBySQL.size() == 100);
//    }
//    @Test
//    @DisplayName("@Query로 JPQL작성 테스트 - 매개변수 네임")
//    public void queryAnnoTest3() {
//        List<Board> list =boardRepository.findByTitleAndWriter3("title1", "writer1");
//        list.forEach(System.out::println);
//        assertTrue(list.size() == 1);
//    }
//    @Test
//    @DisplayName("@Query로 JPQL작성 테스트 - 매개변수 순서")
//    public void queryAnnoTest2() {
//        List<Board> list =boardRepository.findByTitleAndWriter2("title1", "writer1");
//        list.forEach(System.out::println);
//        assertTrue(list.size() == 1);
//    }
//    @Test
//    @DisplayName("@Query로 JPQL작성 테스트")
//    public void queryAnnoTest() {
//        List<Board> list =boardRepository.findAllBoard();
//        list.forEach(System.out::println);
//        assertTrue(list.size() == 100);
//    }
//    @Test
//    @DisplayName("createQuery로 JPQL작성 테스트")
//    public void createQueryTest() {
//        String query = "SELECT b FROM Board b";
//        TypedQuery<Board> tQuery = em.createQuery(query, Board.class);
//        List<Board> list = tQuery.getResultList();
//        list.forEach(System.out::println);
//        assertTrue(list.size() == 100);
//    }
//}