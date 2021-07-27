package com.fsk.blog.services.userservice;

import com.fsk.blog.entities.*;
import com.fsk.blog.repositories.adminrepository.ConferenceRepositoryByAdmin;
import com.fsk.blog.repositories.adminrepository.ExperienceRepositoryByAdmin;
import com.fsk.blog.repositories.adminrepository.ProjectRepositoryByAdmin;
import com.fsk.blog.repositories.adminrepository.ReferenceRepositoryByAdmin;
import com.fsk.blog.repositories.userrepository.AboutMeRepository;
import com.fsk.blog.repositories.userrepository.MasterDegreeRepository;
import com.fsk.blog.repositories.userrepository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutMeService {

    private final AboutMeRepository aboutMeRepository;
    private final UniversityRepository universityRepository;
    private final MasterDegreeRepository masterDegreeRepository;
    private final ExperienceRepositoryByAdmin experienceRepositoryByAdmin;
    private final ProjectRepositoryByAdmin projectRepositoryByAdmin;
    private final ConferenceRepositoryByAdmin conferenceRepositoryByAdmin;
    private final ReferenceRepositoryByAdmin referenceRepositoryByAdmin;

    public Furkan getMyWorld() {
        Long id = 1L;
        Optional<Furkan> furkan = Optional.of(aboutMeRepository.getOne(id));

        if (furkan.isEmpty()) {
            throw new IllegalArgumentException("Bulunamadi");
        }
        return furkan.get();
    }

    public University getUniversity() {
        Long id = 1L;
        return universityRepository.getOne(id);
    }

    public MasterDegree getMasterDegree() {
        Long id = 1L;
        return masterDegreeRepository.getOne(id);
    }
    
    public List<Experience> getAllExperiences() {
        return experienceRepositoryByAdmin.findAll();
    }

    public List<Project> getAllProjects() {
        return projectRepositoryByAdmin.findAll();
    }

    public List<Conference> getAllConferences() {
        return conferenceRepositoryByAdmin.findAll();
    }

    public List<Reference> getAllReferences() {
        return referenceRepositoryByAdmin.findAll();
    }
}
