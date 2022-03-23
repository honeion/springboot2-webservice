package com.honeion.study.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//<Entity 클래스, PK타입> 상속하여 CRUD 생성
//기본 Entity Repository는 함께 위치
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
