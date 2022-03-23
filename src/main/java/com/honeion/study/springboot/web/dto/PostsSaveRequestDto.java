package com.honeion.study.springboot.web.dto;

import com.honeion.study.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//Entity 클래스와 거의 유사함에도 추가로 생성된 이유 (Entity는 Request/Response 클래스로 사용 X)
//DB와 맞닿은 핵심 클래스로 Entity를 기준으로 테이블 생성 및 스키마가 변경되므로
//Request/Response용 Dto는 View를 위한 클래스라 자주 변경하기 때문
//즉, View Layer와 DB Layer의 역할 분리하는 것
//Controller에서 결과값으로 여러 테이블 조인해서 하는 경우 Entity만으로는 표현이 어렵다.
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity() {
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
