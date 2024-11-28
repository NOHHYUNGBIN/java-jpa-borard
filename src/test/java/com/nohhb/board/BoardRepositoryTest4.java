package com.nohhb.board;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static com.nohhb.board.QBoard.board;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest4 {

    @Autowired
    public EntityManager em;
    @Autowired
    private BoardRepository boardRepository;

    // 테스트 할때마다 테스트 코드 실행 직전 자동으로 데이터 입력
    @BeforeEach
    public void testData() {
        for (int i = 1; i <=100; i++) {
            Board board = new Board();
            board.setBno((long) i);
            board.setTitle("title" + i);
            board.setContent("content" + i);
            board.setWriter("writer" + (i % 5)); // writer 0~4
            board.setViewCnt((long) (Math.random()*100)); // 0~99
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardRepository.save(board);
        }
    }
    @Test
    @DisplayName("querydsl로 쿼리 작성테스트1 - 간단한 쿼리작성")
    public void querydslTest1() {
//        QBoard board = QBoard.board; // 상단의 스태틱임포트로 처리가능
        // 1.JPAQueryFactory를 생성
        JPAQueryFactory qf = new JPAQueryFactory(em);
        // 2. 쿼리작성
        JPAQuery<Board> query = qf.selectFrom(board)
                .where(board.title.eq("title1"));
        // 3. 쿼리실행
        List<Board> list = query.fetch();
        list.forEach(System.out::println);
    }
}