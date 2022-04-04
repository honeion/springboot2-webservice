package com.honeion.study.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //Getter 생성 Entity 클래스에서 Setter를 만들지 말고 필요한 경우에만 따로 작성
@NoArgsConstructor //기본 생성자 추가
@Entity //테이블과 링크될 클래스 ex)SalesManger.java->sales_manger table
public class Posts extends BaseTimeEntity{

    @Id //PK fields
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙 IDENTITY -> auto_increment
    private Long id;

    @Column(length = 500, nullable = false) //Default VARCHAR(255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 빌더 패턴 클래스 생성 -> Setter가 없으니 생성자에 채워서 DB에 삽입. 빌더패턴으로 무슨값을 무슨필드에 채우는지 체크
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
