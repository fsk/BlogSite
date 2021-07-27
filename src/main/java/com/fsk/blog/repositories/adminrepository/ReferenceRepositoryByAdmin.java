package com.fsk.blog.repositories.adminrepository;

import com.fsk.blog.entities.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferenceRepositoryByAdmin extends JpaRepository<Reference, Long> {

    Optional<Reference> findByReferenceNameAndReferenceSurname(String referenceName, String referenceSurname);
    void deleteByReferenceNameAndReferenceSurname(String referenceName, String referenceSurname);
}
