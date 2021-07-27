package com.fsk.blog.repositories.adminrepository;

import com.fsk.blog.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ArticleRepositoryByAdmin extends JpaRepository<Article, Long> {
}
