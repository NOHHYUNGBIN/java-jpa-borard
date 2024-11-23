package com.nohhb.board;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

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
