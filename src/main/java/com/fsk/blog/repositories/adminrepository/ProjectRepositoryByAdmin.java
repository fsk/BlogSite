package com.fsk.blog.repositories.adminrepository;

import com.fsk.blog.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepositoryByAdmin extends JpaRepository<Project, Long> {

    List<Project> findByOrderByProjectSequenceDesc();
}
