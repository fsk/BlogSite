package com.fsk.blog.repositories.userrepository;

import com.fsk.blog.entities.Furkan;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface AboutMeRepository extends JpaRepository<Furkan, Long> {


    //Furkan getById(Long id);

}
