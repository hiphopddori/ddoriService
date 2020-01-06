package com.ddori.service.app.domain.posts;

import com.ddori.service.app.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
}
