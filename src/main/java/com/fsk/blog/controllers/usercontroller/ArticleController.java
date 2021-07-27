package com.fsk.blog.controllers.usercontroller;

import com.fsk.blog.entities.Article;
import com.fsk.blog.paths.userpaths.UserArticlePaths;
import com.fsk.blog.services.userservice.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UserArticlePaths.USER_BASE_API + "/" + UserArticlePaths.USER_BASE_BLOG)
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(value = UserArticlePaths.USER_BLOG_LIST)
    public ResponseEntity<List<Article>> getAllBlogPosts() {
        return ResponseEntity.ok(articleService.getAllBlogPosts());
    }

    @GetMapping(value = UserArticlePaths.USER_BLOG_POST_BY_ID + "{id}")
    public ResponseEntity<Article> getBlogPostById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(articleService.getBlogPostById(id));
    }



}


