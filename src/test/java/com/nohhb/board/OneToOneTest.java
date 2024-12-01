package com.nohhb.board;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static com.nohhb.board.QBoard.board;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OneToOneTest {

    @Autowired
    public EntityManager em;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void oneToOneTest() {
        Member member = new Member();
        member.setId(1L);
        member.setPassword("1234");
        member.setName("노형빈");
        member.setEmail("shgudqlsz@naver.com");
        memberRepository.save(member);

        Cart cart = new Cart();
        cart.setId(1L);
        cart.setMember(member);
        cartRepository.save(cart);
        cart = cartRepository.findById(cart.getId()).orElse(null);
        assertTrue(cart != null);
        System.out.println("cart = " + cart);

        member = memberRepository.findById(member.getId()).orElse(null);
        assertTrue(member != null);
        System.out.println("member = " + member);
    }
}