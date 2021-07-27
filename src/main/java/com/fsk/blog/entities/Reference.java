package com.fsk.blog.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "referencesss")
public class Reference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "reference_name", length = 50)
    private String referenceName;



    @Column(name = "reference_surname", length = 50)
    private String referenceSurname;



    @Column(name = "reference_phone_number", length = 13)
    private String referencePhoneNumber;



    @Column(name = "reference_email", length = 100)
    private String referenceEmail;



    @Column(name = "reference_pozition")
    private String referencePozitionNow;



    @Column(name = "reference_relation")
    private String referenceRelation;



    @ManyToOne
    @JoinColumn(name = "aboutme_id")
    private Furkan aboutme;
}
