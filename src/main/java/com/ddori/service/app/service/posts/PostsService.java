package com.ddori.service.app.service.posts;

import com.ddori.service.app.domian.posts.PostsRepository;
import com.ddori.service.app.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requeestDto){
        return postsRepository.save(requeestDto.toEntity()).getId();
    }
}
