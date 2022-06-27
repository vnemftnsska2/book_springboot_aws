package com.example.book_springboot_aws.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @DisplayName("게시글저장_불러오기")
    @Test
    public void saveAndGetPost() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("vnemftnsska2@naver.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertEquals(title, posts.getTitle());
        assertEquals(content, posts.getContent());
    }

    @DisplayName("BaseTimeEntity 등록")
    @Test
    public void testCreateDate() {
        //given
        LocalDateTime now = LocalDateTime.of(2020, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("createDate 테스트")
                .content("BaseTimeEnity 테스트하는 게시글입니다.")
                .author("tnsska2")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println("** createDate="+posts.getCreateDate()+", modifiedDate="+posts.getModifiedDate());

        assertTrue(posts.getCreateDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}