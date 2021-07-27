package com.fsk.blog.repositories.adminrepository;

import com.fsk.blog.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ExperienceRepositoryByAdmin extends JpaRepository<Experience, Long> {


    /**
     * Buradaki attığı hata aşağıdadır.
     * Failed to create query for method public abstract java.util.List com.fsk.blog.repositories.adminrepository.ConferenceRepositoryByAdmin.findByOrderByStartingDateAsc()!
     * No property startingDate found for type Conference!
     */
    //List<Experience> findByOrderByStartingDateAsc();

    //@Query(value = "SELECT " +
    //"e.id, e.company_name, e.starting_date, e.end_date,  e.end_date, e.pozition, e.technologies, e.experience_tpe " +
     //       "FROM experience e ORDER BY e.starting_date asc",
     //       nativeQuery = true)
    List<Experience> findByOrderByStartingDateAsc();

    List<Experience> findAllByCompanyNameContains(String companyName);

    void deleteByCompanyNameLike(String companyName);

    Optional<Experience> findByCompanyName(String companyName);

    void deleteById(Long id);
}
