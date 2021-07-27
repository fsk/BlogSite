package com.fsk.blog.services.userservice;

import com.fsk.blog.entities.Article;
import com.fsk.blog.exceptions.articleexceptions.ArticleNotFoundException;
import com.fsk.blog.repositories.userrepository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;


    public List getAllBlogPosts() {
        return articleRepository.findAll();
    }



    public Article getBlogPostById(Long id) {
        Optional<Article> post = articleRepository.findById(id);

        if (post.isEmpty()) {
            throw new ArticleNotFoundException();
        }

        return post.get();
    }



}
