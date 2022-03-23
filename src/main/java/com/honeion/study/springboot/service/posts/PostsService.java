package com.honeion.study.springboot.service.posts;

import com.honeion.study.springboot.domain.posts.Posts;
import com.honeion.study.springboot.domain.posts.PostsRepository;
import com.honeion.study.springboot.web.dto.PostsResponseDto;
import com.honeion.study.springboot.web.dto.PostsSaveRequestDto;
import com.honeion.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor //이걸로 final 필드 생성자 조치.
@Service
public class PostsService {
    //Bean 주입을 생성자로. Autowired랑 동일한 효과
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){

        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        //DB에 쿼리를 날리지 않는건 JPA의 영속성 컨텍스트(엔티티를 영구 저장하는 환경) 때문
        //논리적 개념으로 엔티티 매니저가 활성화된 상태로 (Spring Data Jpa 쓰면 기본 옵션)
        //트랜잭션 안에서 DB에서 데이터를 가져오면 해당 데이터가 영속성 컨텍스트가 유지된 상태
        //이상태에서 해당 데이터 값 변경 시 트랜잭션 끝나는 시점에 해당 테이블에 변경분을 반영
        //Entity 값만 변경하면 별도로 Update 쿼리 날릴 필요가 없음 => 더티 체킹(dirty checking)이라고 함.
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
