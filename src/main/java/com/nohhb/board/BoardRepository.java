package com.nohhb.board;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    @Query("SELECT b FROM Board b") // JPQL은 대소문자 구분에 주의
    List<Board> findAllBoard();

    @Query("SELECT b FROM Board b WHERE b.title =?1 AND b.writer=?2") // JPQL은 대소문자 구분에 주의
    List<Board> findByTitleAndWriter2(String title, String writer);

    @Query("SELECT b FROM Board b WHERE b.title =:title AND b.writer=:writer") // JPQL은 대소문자 구분에 주의
    List<Board> findByTitleAndWriter3(String title, String writer);

    @Query(value="SELECT * FROM BOARD", nativeQuery = true) // JPQL은 대소문자 구분에 주의
    List<Board> findAllBoardBySQL();

    @Query(value="SELECT TITLE,WRITER FROM BOARD", nativeQuery = true) // JPQL은 대소문자 구분에 주의
    List<Object[]> findAllBoardBySQL2();

    // select count(*) from board where writer = :writer 와 같음.
    int countAllByWriter(String writer);

    // select * from board where writer = :writer 와 같음.
    List<Board> findByWriter(String writer);

    // select * from board where title=:title and writer = :writer 와 같음.
    List<Board> findByTitleAndWriter(String title, String writer);

    // delete from board where whiter = :writer 와 같음.
    @Transactional // delete의 경우, 여러건을 delete 할수 있기 때문에 Tx처리 필수
    int deleteByWriter(String writer);
}
