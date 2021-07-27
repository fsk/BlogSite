package com.fsk.blog.repositories.adminrepository;

import com.fsk.blog.entities.Furkan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

//@Repository
public interface AboutMeRepositoryByAdmin extends JpaRepository<Furkan, Long> {

    //List<Experience> findAllByExperience();

    /*@Query(value =
            "SELECT " +
                    "a.contact_id, a.high_school, " +
                    "a.master_degree_id, " +
                    "a.university_id, a.profil_image, " +
                    "e.id, e.company_name, e.starting_date, e.end_date, e.experience_type, e.pozition, e.explanation " +
                    "from ABOUTME_EXPERIENCE ae " +
                    "INNER JOIN EXPERIENCE e " +
                    "on ae.experience_id = e.id " +
                    "INNER JOIN ABOUTME a " +
                    "on a.id = ae.furkan_id " +
                    "order by e.starting_date",
            nativeQuery = true)
    Collection<Furkan> findAllExperiences();*/


}
