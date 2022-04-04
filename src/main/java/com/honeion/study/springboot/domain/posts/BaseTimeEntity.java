package com.honeion.study.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate,modifiedDate)도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능 포함 시킴
public abstract class BaseTimeEntity {
    
    @CreatedDate // Entity 생성되어 저장될때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 값 변경시 시간 자동 저장
    private LocalDateTime modifiedDate;
}
