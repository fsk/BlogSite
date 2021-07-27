package com.fsk.blog.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "project_name")
    private String projectName;


    @ElementCollection
    @Column(name = "technologies")
    private List<String> technologies = new ArrayList<>();


    @Column(name = "project_explanation")
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String explanation;


    @Column(name = "github_link")
    private String githubLink;


    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @Column(name = "project_sequence")
    private Integer projectSequence;


    @ManyToOne
    @JoinColumn(name = "aboutme_id")
    private Furkan aboutme;


}
