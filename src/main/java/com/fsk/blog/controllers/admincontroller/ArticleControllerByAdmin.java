package com.fsk.blog.controllers.admincontroller;


import com.fsk.blog.entities.Article;
import com.fsk.blog.paths.adminpaths.AdminArticlePaths;
import com.fsk.blog.services.adminservice.ArticleServiceByAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(AdminArticlePaths.ADMIN_BASE_API + "/" + AdminArticlePaths.ADMIN_BASE_BLOG)
@RequiredArgsConstructor
public class ArticleControllerByAdmin {

    private final ArticleServiceByAdmin articleServiceByAdmin;

    @GetMapping(value = AdminArticlePaths.ADMIN_GET_ALL_ARTICLES)
    public ResponseEntity<List<Article>> getAllBlogPosts() {
        return ResponseEntity.ok(articleServiceByAdmin.getAllBlogPosts());
    }

    @GetMapping(value = AdminArticlePaths.ADMIN_GET_ARTICLE_BY_ID + "{id}")
    public ResponseEntity<Article> getBlogPostById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(articleServiceByAdmin.getBlogPostById(id));
    }

    @DeleteMapping(value = AdminArticlePaths.ADMIN_DELETE_ARTICLE_BY_ID + "{id}")
    public ResponseEntity deleteArticleById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(articleServiceByAdmin.deleteArticleById(id));
    }


    @DeleteMapping(value = AdminArticlePaths.ADMIN_DELETE_ALL_ARTICLES)
    public ResponseEntity deleteAllArticles(){
        return ResponseEntity.ok(articleServiceByAdmin.deleteAllArticles());
    }


    @PostMapping(value = AdminArticlePaths.ADMIN_WRITE_ARTICLE)
    public ResponseEntity<Article> writeArticle(@RequestBody Article article) {
        return ResponseEntity.ok(articleServiceByAdmin.saveArticle(article));
    }


    @PutMapping(value = AdminArticlePaths.ADMIN_UPDATE_ARTICLE_BY_ID + "{id}")
    public ResponseEntity<Article> updateArticleById(@PathVariable(value = "id") Long id, @RequestBody Article article) {
        return ResponseEntity.ok(articleServiceByAdmin.updateArticleById(id, article));
    }

}
