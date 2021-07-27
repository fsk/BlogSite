package com.fsk.blog.repositories.adminrepository;

import com.fsk.blog.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConferenceRepositoryByAdmin extends JpaRepository<Conference, Long> {

    //@Query(value = "SELECT FROM conference c order by ", nativeQuery = true)
    List<Conference> findByOrderByConferenceDateDesc();
}
