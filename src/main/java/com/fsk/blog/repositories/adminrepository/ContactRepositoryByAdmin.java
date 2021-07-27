package com.fsk.blog.repositories.adminrepository;

import com.fsk.blog.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepositoryByAdmin extends JpaRepository<Contact, Long> {
}
