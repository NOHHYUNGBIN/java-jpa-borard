package com.nohhb.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BoardApplication implements CommandLineRunner {
    @Autowired
    EntityManagerFactory emf;
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BoardApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        EntityManager em = emf.createEntityManager();
        System.out.println("em = " + em);
        EntityTransaction tx = em.getTransaction();

        User user = new User();
        user.setId("aaa");
        user.setPassword("1234");
        user.setEmail("aaa@gmail.com");
        user.setName("Noh");
        user.setInDate(new Date());
        user.setUpDate(new Date());

        tx.begin(); // 트랜잭션 시작
        // 1. 저장
        em.persist(user); // user엔티티를 em에 영속화(저장)
        // 2. 변경.
        user.setPassword("4321"); // PersistenceContext가 변경감지. (update문 실행)
        tx.commit(); // 트랜잭션 종료(DB에 반영)
        // 3. 조회
        User user2 = em.find(User.class, "aaa"); // em에 있으면 DB조회 안함
        System.out.println("user2 = " + user2);
        User user4 = em.find(User.class, "bbb"); // em에 없으면 DB조회
        System.out.println("user4 = " + user4); // null, DB에 없음.
        // 4. 삭제
        tx.begin(); // 트랜잭션 시작
        em.remove(user); // em에서 user엔티티를 삭제
        tx.commit(); // 트랜잭션 종료(DB에 반영)
    }
}
