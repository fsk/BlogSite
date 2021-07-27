package com.fsk.blog.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "article")

public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "article_title", length = 100, nullable = false)

    private String articleTitle;

    @Lob
    @Column(name = "article_content", nullable = false)
    private String articleContent;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "article_image")
    private byte[] image;

    @Column(name = "created_date")
    //@Temporal(TemporalType.TIMESTAMP)
    private String createdDate;

    @Column(name = "updated_date")
    //@Temporal(TemporalType.TIMESTAMP)
    private String updatedDate;

}
