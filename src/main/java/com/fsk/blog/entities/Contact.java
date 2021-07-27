package com.fsk.blog.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "phone_number", length = 13, nullable = false)
    private String phone;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @Column(name = "github", length = 20, nullable = false)
    private String github;

    @Column(name = "twitter", length = 30, nullable = false)
    private String twitter;

    @Column(name = "instagram", length = 30, nullable = false)
    private String instagram;

    @Column(name = "linkedin", length = 100, nullable = false)
    private String linkedin;

    @Column(name = "superpeer", length = 20, nullable = false)
    private String superpeer;

}
