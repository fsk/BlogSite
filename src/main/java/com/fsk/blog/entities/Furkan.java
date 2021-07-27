package com.fsk.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "aboutme")
public class Furkan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "profil_image")
    private byte[] profileImage;



    @Column(name = "high_school", length = 40, updatable = false, insertable = false)
    private String high_school;




    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private University university;


    /**
     * Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.http.converter.HttpMessageConversionException:
     * Type definition error: [simple type, class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
     * No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
     * (through reference chain: com.fsk.blog.entities.Furkan$HibernateProxy$0LMWlniv["masterDegree"]->com.fsk.blog.entities.MasterDegree$HibernateProxy$vTtYDNii["hibernateLazyInitializer"])] with root cause
     *
     * OneToOne ilişkilerde @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) bunu eklemezsem yukarıdaki hatayı alıyorum.
     */

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MasterDegree masterDegree;



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "aboutme", orphanRemoval = true)
    private Set<Experience> experience;



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "aboutme", orphanRemoval = true)
    private Set<Conference> conferences;



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "aboutme", orphanRemoval = true)
    private Set<Project> projects;



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "aboutme", orphanRemoval = true)
    private Set<Reference> references;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Contact contact;

}
