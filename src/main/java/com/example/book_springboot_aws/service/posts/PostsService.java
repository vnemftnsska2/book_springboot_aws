package com.example.book_springboot_aws.service.posts;

import com.example.book_springboot_aws.domain.posts.Posts;
import com.example.book_springboot_aws.domain.posts.PostsRepository;
import com.example.book_springboot_aws.web.dto.PostResponseDto;
import com.example.book_springboot_aws.web.dto.PostsSaveRequestDto;
import com.example.book_springboot_aws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        return new PostResponseDto(entity);
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        posts.update(title, content);
        return id;
    }
}
