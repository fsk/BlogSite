package com.fsk.blog.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseUniClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "university_name", length = 150)
    private String universityName;

    @Column(name = "faculty_name", length = 150)
    private String facultyName;

    @Column(name = "department_name", length = 50)
    private String departmentName;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "start_time")
    @Temporal(TemporalType.DATE)
    private Date startingDate;

    @Column(name = "end_time")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name = "average")
    private Float average;

    //@OneToOne
    //@JoinColumn(name = "aboutme_id")
    //private Furkan furkan;

}
