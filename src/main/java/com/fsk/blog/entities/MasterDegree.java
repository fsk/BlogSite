package com.fsk.blog.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "master_degree")
public class MasterDegree extends BaseUniClass implements Serializable {

    @Column(name = "thesis_subject")
    private String thesisSubject;

}
