package com.fsk.blog.services.adminservice;

import com.fsk.blog.entities.Article;
import com.fsk.blog.exceptions.articleexceptions.ArticleNotFoundException;
import com.fsk.blog.repositories.adminrepository.ArticleRepositoryByAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceByAdmin {

    private final ArticleRepositoryByAdmin articleRepositoryByAdmin;



    public List getAllBlogPosts() {
        return articleRepositoryByAdmin.findAll();
    }



    public Article getBlogPostById(Long id) {
        Optional<Article> post = articleRepositoryByAdmin.findById(id);

        if (post.isEmpty()) {
            throw new ArticleNotFoundException();
        }

        return post.get();
    }


    public ResponseEntity deleteArticleById(Long id) {

        Optional<Article> post = articleRepositoryByAdmin.findById(id);

        if (post.isEmpty()) {
            throw new ArticleNotFoundException();
        }

        articleRepositoryByAdmin.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    public ResponseEntity deleteAllArticles() {
        articleRepositoryByAdmin.deleteAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }



    public Article saveArticle(Article article) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        article.setCreatedDate(formatter.format(date));
        return articleRepositoryByAdmin.save(article);
    }


    public Article updateArticleById(Long id, Article article) {

        Optional<Article> post = articleRepositoryByAdmin.findById(id);

        if (post.isEmpty()) {
            throw new ArticleNotFoundException();
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        article.setUpdatedDate(formatter.format(date));

        return articleRepositoryByAdmin.save(article);

    }
}
