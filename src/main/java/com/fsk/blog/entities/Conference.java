package com.fsk.blog.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Table(name = "conferences")
@Entity
public class Conference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "conference_name")
    private String conferenceName;


    @Column(name = "conference_subject", length = 100)
    private String conferenceSubject;



    @Column(name = "who_is", length = 50)
    private String who_is;


    @Column(name = "city", length = 15)
    private String city;



    @Column(name = "conference_date", length = 10)
    private String conferenceDate;

    @ManyToOne
    @JoinColumn(name = "aboutme_id")
    private Furkan aboutme;

}
