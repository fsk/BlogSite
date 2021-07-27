package com.fsk.blog.repositories.userrepository;

import com.fsk.blog.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
