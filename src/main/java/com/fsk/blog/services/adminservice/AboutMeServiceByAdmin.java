package com.fsk.blog.services.adminservice;

import com.fsk.blog.entities.*;

import com.fsk.blog.exceptions.aboutmeexceptions.CompanyNotFoundException;
import com.fsk.blog.exceptions.aboutmeexceptions.ConferenceNotFoundException;
import com.fsk.blog.exceptions.aboutmeexceptions.ProjectNotFoundException;
import com.fsk.blog.exceptions.aboutmeexceptions.ReferenceNotFoundException;
import com.fsk.blog.repositories.adminrepository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class AboutMeServiceByAdmin {

    //DEPENDENCY INJECTIONS
    private final ExperienceRepositoryByAdmin experienceRepositoryByAdmin;
    private final ConferenceRepositoryByAdmin conferenceRepositoryByAdmin;
    private final ContactRepositoryByAdmin contactRepositoryByAdmin;
    private final ReferenceRepositoryByAdmin referenceRepositoryByAdmin;
    private final ProjectRepositoryByAdmin projectRepositoryByAdmin;

    /**
     * EXPERIENCE
     */

    //GET ALL EXPERIENCES
    public List<Experience> getAllExperiences() {
        //return experienceRepositoryByAdmin.findAll();
        //return experienceRepositoryByAdmin.findAllByExperienceOrderByStartingDate();

        return experienceRepositoryByAdmin.findByOrderByStartingDateAsc();
        //return experienceRepositoryByAdmin.findAll();
    }

    //GET EXPERIENCE BY COMPANY NAME
    public List<Experience> getExperienceByCompanyName(String companyName) {
        Optional<List<Experience>> experience = Optional.ofNullable(experienceRepositoryByAdmin
                .findAllByCompanyNameContains(companyName.trim().toLowerCase()));


        if (experience.isEmpty()) {
            throw new CompanyNotFoundException();
        }

        return experience.get();
    }


    //GET EXPERIENCE BY ID
    public Experience getExperienceById(Long id) {
        Optional<Experience> experience = experienceRepositoryByAdmin.findById(id);

        if (experience.isEmpty()) {
            throw new CompanyNotFoundException();
        }

        return experience.get();
    }


    //DELETE EXPERIENCE BY ID
    public void deleteExperienceById(Long id) {
        Optional<Experience> experience = experienceRepositoryByAdmin.findById(id);

        if (experience.isEmpty()) {
            throw new CompanyNotFoundException();
        }

        experienceRepositoryByAdmin.deleteById(id);

    }


    //DELETE EXPERIENCE BY COMPANY NAME
    public void deleteExperienceByCompanyName(String companyName) {
        Optional<List<Experience>> experience = Optional.ofNullable(experienceRepositoryByAdmin
                .findAllByCompanyNameContains(companyName.trim().toLowerCase()));

        if (experience.isEmpty()) {
            throw new CompanyNotFoundException();
        }


        experienceRepositoryByAdmin.deleteByCompanyNameLike(companyName);

    }


    //SAVE EXPERIENCE
    public Experience saveExperience(Experience experience) {
        return experienceRepositoryByAdmin.save(experience);
    }

    //UPDATE EXPERIENCE BY ID
    public Experience updateExperienceById(Long id, Experience experience) {

        Optional<Experience> updateExperience = experienceRepositoryByAdmin.findById(id);

        if (updateExperience.isEmpty()) {
            throw new CompanyNotFoundException();
        }

        updateExperience.get().setCompanyName(experience.getCompanyName());
        updateExperience.get().setStartingDate(experience.getStartingDate());
        updateExperience.get().setDueDate(experience.getDueDate());
        updateExperience.get().setPozition(experience.getPozition());
        updateExperience.get().setTechnologies(experience.getTechnologies());
        updateExperience.get().setExperienceType(experience.getExperienceType());
        updateExperience.get().setExplanation(experience.getExplanation());


        return experienceRepositoryByAdmin.save(updateExperience.get());
    }


    //UPDATE EXPERIENCE BY COMPANY NAME
    public Experience updateExperienceByCompanyName(String companyName, Experience experience) {

        Optional<Experience> updateExperience = experienceRepositoryByAdmin
                .findByCompanyName(companyName);

        if (updateExperience.isEmpty()) {
            throw new CompanyNotFoundException();
        }

        updateExperience.get().setCompanyName(experience.getCompanyName());
        updateExperience.get().setStartingDate(experience.getStartingDate());
        updateExperience.get().setDueDate(experience.getDueDate());
        updateExperience.get().setPozition(experience.getPozition());
        updateExperience.get().setTechnologies(experience.getTechnologies());
        updateExperience.get().setExperienceType(experience.getExperienceType());
        updateExperience.get().setExplanation(experience.getExplanation());

        return experienceRepositoryByAdmin.save(updateExperience.get());
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * CONFERENCE
     */

    //GET ALL CONFERENCES
    public List<Conference> getAllConferences() {
        return conferenceRepositoryByAdmin.findByOrderByConferenceDateDesc();
    }


    //GET CONFERENCE BY ID
    public Conference getConferenceById(Long id) {
        Optional<Conference> conference = conferenceRepositoryByAdmin.findById(id);

        if (conference.isEmpty()) {
            throw new ConferenceNotFoundException();
        }

        return conference.get();
    }


    //DELETE CONFERENCE BY ID
    public void deleteConferenceById(Long id) {
        Optional<Conference> conference = conferenceRepositoryByAdmin.findById(id);

        if (conference.isEmpty()) {
            throw new ConferenceNotFoundException();
        }

        conferenceRepositoryByAdmin.deleteById(id);
    }


    //SAVE CONFERENCE
    public Conference saveConference(Conference conference) {
        return conferenceRepositoryByAdmin.save(conference);
    }

    //UPDATE CONFERENCE
    public Conference updateConferenceById(Long id, Conference conference) {
        Optional<Conference> updateConference = conferenceRepositoryByAdmin.findById(id);

        if (updateConference.isEmpty()) {
            throw new ConferenceNotFoundException();
        }

        updateConference.get().setConferenceName(conference.getConferenceName());
        updateConference.get().setConferenceSubject(conference.getConferenceSubject());
        updateConference.get().setWho_is(conference.getWho_is());
        updateConference.get().setCity(conference.getCity());
        updateConference.get().setConferenceDate(conference.getConferenceDate());

        return conferenceRepositoryByAdmin.save(updateConference.get());
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * CONTACT
     */

    //GET CONTACT INFORMATION
    public Contact getContactInformation() {
        Long id = 1L;
        return contactRepositoryByAdmin.findById(id).get();
    }

    //UPDATE CONTACT INFORMATION
    public Contact updateContactInformations(Contact contact) {
        Long id = 1L;

        Optional<Contact> updateContact = contactRepositoryByAdmin.findById(id);

        updateContact.get().setPhone(contact.getPhone());
        updateContact.get().setEmail(contact.getEmail());
        updateContact.get().setCity(contact.getCity());

        return contactRepositoryByAdmin.save(updateContact.get());
    }


    //------------------------------------------------------------------------------------------------------------------

    /**
     * REFERENCE
     */

    //GET ALL REFERENCES
    public List<Reference> getAllReferences() {
        return referenceRepositoryByAdmin.findAll();
    }


    //GET REFERENCE BY ID
    public Reference getReferenceById(Long id) {
        Optional<Reference> reference = referenceRepositoryByAdmin.findById(id);

        if (reference.isEmpty()) {
            throw new ReferenceNotFoundException();
        }

        return reference.get();
    }


    //GET REFERENCE BY NAME AND SURNAME
    public Reference getReferenceByNameAndSurname(String referenceName, String referenceSurname) {
        Optional<Reference> reference = referenceRepositoryByAdmin
                .findByReferenceNameAndReferenceSurname(referenceName, referenceSurname);

        if (reference.isEmpty()) {
            throw new ReferenceNotFoundException();
        }

        return reference.get();
    }

    //DELETE REFERENCE BY ID
    public void deleteReferenceById(Long id) {
        Optional<Reference> reference = referenceRepositoryByAdmin.findById(id);
        if (reference.isEmpty()) {
            throw new ReferenceNotFoundException();
        }

        referenceRepositoryByAdmin.deleteById(id);
    }


    //DELETE REFERENCE BY NAME AND SURNAME
    public void deleteReferenceByNameAndSurname(String referenceName, String referenceSurname) {
        Optional<Reference> reference = referenceRepositoryByAdmin
                .findByReferenceNameAndReferenceSurname(referenceName, referenceSurname);
        if (reference.isEmpty()) {
            throw new ReferenceNotFoundException();
        }
        referenceRepositoryByAdmin.deleteByReferenceNameAndReferenceSurname(referenceName, referenceName);
    }


    //UPDATE REFERENCE BY ID
    public Reference updateReferenceById(Long id, Reference reference) {
        Optional<Reference> updateReference = referenceRepositoryByAdmin.findById(id);
        if (updateReference.isEmpty()) {
            throw new ReferenceNotFoundException();
        }

        updateReference.get().setReferenceName(reference.getReferenceName());
        updateReference.get().setReferenceSurname(reference.getReferenceSurname());
        updateReference.get().setReferencePhoneNumber(reference.getReferencePhoneNumber());
        updateReference.get().setReferenceEmail(reference.getReferenceEmail());
        updateReference.get().setReferencePozitionNow(reference.getReferencePozitionNow());
        updateReference.get().setReferenceRelation(reference.getReferenceRelation());

        return referenceRepositoryByAdmin.save(updateReference.get());

    }

    //UPDATE REFERENCE BY NAME AND SURNAME
    public Reference updateReferenceByNameAndSurname(String referenceName, String referenceSurname, Reference reference) {

        Optional<Reference> updateReference = referenceRepositoryByAdmin
                .findByReferenceNameAndReferenceSurname(referenceName, referenceSurname);

        if (updateReference.isEmpty()) {
            throw new ReferenceNotFoundException();
        }

        updateReference.get().setReferenceName(reference.getReferenceName());
        updateReference.get().setReferenceSurname(reference.getReferenceSurname());
        updateReference.get().setReferencePhoneNumber(reference.getReferencePhoneNumber());
        updateReference.get().setReferenceEmail(reference.getReferenceEmail());
        updateReference.get().setReferencePozitionNow(reference.getReferencePozitionNow());
        updateReference.get().setReferenceRelation(reference.getReferenceRelation());

        return referenceRepositoryByAdmin.save(updateReference.get());



    }

    //INSERT REFERENCE
    public Reference insertReference(Reference reference) {
        return referenceRepositoryByAdmin.save(reference);
    }




    //------------------------------------------------------------------------------------------------------------------

    /**
     * PROJECT
     */

    //INSERT PROJECT
    public Project insertProject(Project project) {
        return projectRepositoryByAdmin.save(project);
    }


    //GET ALL PROJECTS
    public List<Project> getAllProjects() {
        return projectRepositoryByAdmin.findByOrderByProjectSequenceDesc();
    }


    //GET PROJECT BY ID
    public Project getProjectById(Long id) {
        Optional<Project> project = projectRepositoryByAdmin.findById(id);

        if (project.isEmpty()) {
            throw new ProjectNotFoundException();
        }

        return project.get();
    }


    //UPDATE PROJECT BY ID
    public Project updateProjectById(Long id, Project project) {
        Optional<Project> updateProject = projectRepositoryByAdmin.findById(id);

        if (updateProject.isEmpty()) {
            throw new ProjectNotFoundException();
        }

        updateProject.get().setProjectName(project.getProjectName());
        updateProject.get().setTechnologies(project.getTechnologies());
        updateProject.get().setExplanation(project.getExplanation());
        updateProject.get().setGithubLink(project.getGithubLink());
        updateProject.get().setProjectStatus(project.getProjectStatus());

        return projectRepositoryByAdmin.save(updateProject.get());
    }


    //DELETE PROJECT BY ID
    public void deleteProjectById(Long id) {
        Optional<Project> project = projectRepositoryByAdmin.findById(id);

        if (project.isEmpty()) {
            throw new ProjectNotFoundException();
        }

        projectRepositoryByAdmin.deleteById(id);
    }
}
