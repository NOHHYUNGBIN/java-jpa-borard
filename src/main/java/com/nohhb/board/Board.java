package com.nohhb.board;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Board {

    @Id  // pk
    @GeneratedValue // 자동번호 증가
    private long bno;

    private String title;

    private String content;

//    private String writer;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Long viewCnt;

    @Temporal(value= TemporalType.TIMESTAMP)
    private Date inDate;
    @Temporal(value= TemporalType.TIMESTAMP)
    private Date upDate;

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
//                ", user=" + user +
                ", viewCnt=" + viewCnt +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getBno() {
        return bno;
    }

    public void setBno(long bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Long viewCnt) {
        this.viewCnt = viewCnt;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}
