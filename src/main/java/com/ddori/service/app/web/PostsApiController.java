package com.ddori.service.app.web;

import com.ddori.service.app.domian.posts.Posts;
import com.ddori.service.app.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsApiController postsApiController;

    @PutMapping("/app/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requeestDto){
        return postsApiController.save(requeestDto);
    }
}
