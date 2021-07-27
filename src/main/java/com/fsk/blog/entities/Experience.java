package com.fsk.blog.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "experience")
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "company_name", length = 200, nullable = false)
    private String companyName;

    @Column(name = "starting_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startingDate;


    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date dueDate;

    @Column(name = "pozition", nullable = false, length = 50)
    private String pozition;

    @ElementCollection
    @Column(name = "technologies")
    private List<String> technologies = new ArrayList<>();


    @Column(name = "experience_type", nullable = true)
    @Enumerated(EnumType.STRING)
    private ExperienceType experienceType;


    @Column(name = "explanation", nullable = false)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String explanation;

    @ManyToOne
    @JoinColumn(name = "aboutme_id")
    private Furkan aboutme;
}
