package com.ezen.management.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "curriculum")
public class Lesson extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Curriculum curriculum;

    //과정 설명(내용)
    private String content;

    //교사
    @ManyToOne
    private Member member;

    //기수
    @Column(nullable = false)
    private int number;

    //인원
    @Builder.Default
    private int headCount = 0;

    @Column(nullable = false)
    private LocalDate startDay;

    @Column(nullable = false)
    private LocalDate endDay;

    @Column(nullable = false)
    private LocalDate survey1;

    @Column(nullable = false)
    private LocalDate survey2;

    @Column(nullable = false)
    private LocalDate survey3;

    private String classRoom;

    private String questionName;


    public void changeTeacher(Member member){
        this.member = member;
    }

    public void changeClassroom(String classRoom) {
        this.classRoom = classRoom;
    }

    public void changeQuestionName(String questionName){
        this.questionName = questionName;
    }

    public void headCountUp(){
        this.headCount++;
    }


    public void changeCurriculum(Curriculum curriculum){this.curriculum = curriculum;}


    public void changeContent(String content){
        this.content = content;
    }


}