package com.fsk.blog.controllers.admincontroller;

import com.fsk.blog.entities.*;
import com.fsk.blog.paths.adminpaths.AdminAboutMePaths;
import com.fsk.blog.services.adminservice.AboutMeServiceByAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = AdminAboutMePaths.MANAGE_CAREER)
@RequiredArgsConstructor
public class AboutMeControllerByAdmin {

    //DEPENDENCY INJECTION
    private final AboutMeServiceByAdmin aboutMeServiceByAdmin;

    //------------------------------------------------------------------------------------------------------------------

    /**
     * --- EXPERIENCE ---
     */

    //ALL EXPERIENCES
    @GetMapping(value = AdminAboutMePaths.GET_ALL_EXPERIENCES)
    public ResponseEntity<List<Experience>> getAllExperiences(){
        return ResponseEntity.ok(aboutMeServiceByAdmin.getAllExperiences());
    }

    //EXPERIENCES BY COMPANY NAME
    @GetMapping(value = AdminAboutMePaths.GET_EXPERIENCE_BY_COMPANY_NAME + "{companyName}")
    public ResponseEntity<List<Experience>> getExperienceByCompanyName(@PathVariable(value = "companyName") String companyName){
        return ResponseEntity.ok(aboutMeServiceByAdmin.getExperienceByCompanyName(companyName));
    }


    //EXPERIENCE BY ID
    @GetMapping(value = AdminAboutMePaths.GET_EXPERIENCE_BY_ID + "{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.getExperienceById(id));
    }


    //DELETE EXPERIENCE BY ID
    @DeleteMapping(value = AdminAboutMePaths.DELETE_EXPERIENCE_BY_ID + "{id}")
    public void deleteExperienceById(@PathVariable(value = "id") Long id) {
        aboutMeServiceByAdmin.deleteExperienceById(id);
    }

    //DELETE EXPERIENCE BY COMPANY NAME
    @DeleteMapping(value = AdminAboutMePaths.DELETE_EXPERIENCE_BY_COMPANY_NAME + "{companyName}")
    public void deleteExperienceById(@PathVariable(value = "companyName") String companyName) {
        aboutMeServiceByAdmin.deleteExperienceByCompanyName(companyName);
    }

    //INSERT EXPERIENCE
    @PostMapping(value = AdminAboutMePaths.INSERT_EXPERIENCE)
    public ResponseEntity<Experience> insertExperience(@RequestBody Experience experience) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.saveExperience(experience));
    }

    //UPDATE EXPERIENCE BY ID
    @PostMapping(value = AdminAboutMePaths.UPDATE_EXPERIENCE_BY_ID + "{id}")
    public ResponseEntity<Experience> updateExperienceById(@PathVariable(value = "id") Long id,  @RequestBody Experience experience) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.updateExperienceById(id, experience));
    }

    //UPDATE EXPERIENCE BY COMPANY NAME
    @PostMapping(value = AdminAboutMePaths.UPDATE_EXPERIENCE_BY_COMPANY_NAME + "{companyName}")
    public ResponseEntity<Experience> updateExperienceByCompanyName(@PathVariable(value = "companyName") String companyName, @RequestBody Experience experience) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.updateExperienceByCompanyName(companyName, experience));
    }

    //------------------------------------------------------------------------------------------------------------------


    /**
     * CONFERENCES
     */

    //GET ALL CONFERENCES
    @GetMapping(value = AdminAboutMePaths.GET_ALL_CONFERENCES)
    public ResponseEntity<List<Conference>> getAllConferences(){
        return ResponseEntity.ok(aboutMeServiceByAdmin.getAllConferences());
    }

    //GET CONFERENCE BY ID
    @GetMapping(value = AdminAboutMePaths.GET_CONFERENCE_BY_ID + "{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.getConferenceById(id));
    }

    //DELETE CONFERENCE BY ID
    @DeleteMapping(AdminAboutMePaths.DELETE_CONFERENCE_BY_ID + "{id}")
    public void deleteConferenceById(@PathVariable(value = "id") Long id) {
        aboutMeServiceByAdmin.deleteConferenceById(id);
    }

    //INSERT CONFERENCE
    @PostMapping(AdminAboutMePaths.INSERT_CONFERENCE)
    public ResponseEntity<Conference> insertConference(@RequestBody Conference conference) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.saveConference(conference));
    }

    //UPDATE CONFERENCE BY ID
    @PostMapping(AdminAboutMePaths.UPDATE_CONFERENCE_BY_ID + "{id}")
    public ResponseEntity<Conference> updateConferenceById(@PathVariable(value = "id") Long id, @RequestBody Conference conference) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.updateConferenceById(id, conference));
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * CONTACT
     */

    //GET CONTACT INFORMATIONS
    @GetMapping(value = AdminAboutMePaths.GET_CONTACT_INFORMATION)
    public ResponseEntity<Contact> getContactInformations() {
        return ResponseEntity.ok(aboutMeServiceByAdmin.getContactInformation());
    }

    @PostMapping(value = AdminAboutMePaths.UPDATE_CONTACT_INFORMATION)
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.updateContactInformations(contact));
    }


    //------------------------------------------------------------------------------------------------------------------


    /**
     * REFERENCES
     */

    //INSERT REFERENCE
    @PostMapping(value = AdminAboutMePaths.INSERT_REFERENCE)
    public ResponseEntity<Reference> insertReference(@RequestBody Reference reference){
        return ResponseEntity.ok(aboutMeServiceByAdmin.insertReference(reference));
    }

    //GET ALL REFERENCES
    @GetMapping(value = AdminAboutMePaths.GET_ALL_REFERENCES)
    public ResponseEntity<List<Reference>> getAllReferences() {
        return ResponseEntity.ok(aboutMeServiceByAdmin.getAllReferences());
    }

    //GET REFERENCE BY ID
    @GetMapping(value = AdminAboutMePaths.GET_REFERENCE_BY_ID + "{id}")
    public ResponseEntity<Reference> getReferenceById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.getReferenceById(id));
    }

    //GET REFERENCE BY REFERENCE NAME
    @GetMapping(value = AdminAboutMePaths.GET_REFERENCE_BY_NAME_AND_SURNAME + "{referenceName}" + "/" + "{referenceSurname}")
    public ResponseEntity<Reference> getReferenceByNameAndSurname(
            @PathVariable(value = "referenceName")String referenceName,  @PathVariable(value = "referenceSurname") String referenceSurname) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.getReferenceByNameAndSurname(referenceName, referenceSurname));
    }

    //DELETE REFERENCE BY ID
    @DeleteMapping(value = AdminAboutMePaths.DELETE_REFERENCE_BY_ID + "{id}")
    public void deleteReferenceById(@PathVariable(value = "id")Long id) {
        aboutMeServiceByAdmin.deleteReferenceById(id);
    }


    //DELETE REFERENCE BY NAME AND SURNAME
    @DeleteMapping(value = AdminAboutMePaths.DELETE_REFERENCE_BY_NAME_AND_SURNAME + "{referenceName}" + "/" + "{referenceSurname}")
    public void deleteReferenceByNameAndSurname(@PathVariable(value = "referenceName")String referenceName,
                                                @PathVariable(value = "referenceSurname")String referenceSurname) {
        aboutMeServiceByAdmin.deleteReferenceByNameAndSurname(referenceName, referenceSurname);

    }


    //UPDATE REFERENCE BY ID
    @PutMapping(value = AdminAboutMePaths.UPDATE_REFERENCE_BY_ID + "{id}")
    public ResponseEntity<Reference> updateReferenceById(@PathVariable(value = "id")Long id, @RequestBody Reference reference) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.updateReferenceById(id, reference));
    }


    //UPDATE REFERENCE BY NAME AND SURNAME
    @PutMapping(value = AdminAboutMePaths.UPDATE_REFERENCE_BY_NAME_AND_SURNAME + "{referenceName}" + "/" + "{referenceSurname}")
    public ResponseEntity<Reference> updateReferenceByIdNameAndSurname(@PathVariable(value = "referenceName")String referenceName,
                                                  @PathVariable(value = "referenceSurname")String referenceSurname, @RequestBody Reference reference) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.updateReferenceByNameAndSurname(referenceName, referenceSurname, reference));
    }




    //------------------------------------------------------------------------------------------------------------------


    /**
     * PROJECT
     */


    //INSERT PROJECT
    @PostMapping(AdminAboutMePaths.INSERT_PROJECT)
    public ResponseEntity<Project> insertProject(@RequestBody Project project) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.insertProject(project));
    }

    //GET ALL PROJECTS
    @GetMapping(AdminAboutMePaths.GET_ALL_PROJECTS)
    public ResponseEntity<List<Project>> getAllProjects(){
        return ResponseEntity.ok(aboutMeServiceByAdmin.getAllProjects());
    }

    //GET PROJECT BY ID
    @GetMapping(AdminAboutMePaths.GET_PROJECT_BY_ID + "{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable(value = "id")Long id) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.getProjectById(id));
    }

    //DELETE PROJECT BY ID
    @DeleteMapping(AdminAboutMePaths.DELETE_PROJECT_BY_ID + "{id}")
    public void deleteProjectById(@PathVariable(value = "id")Long id) {
       aboutMeServiceByAdmin.deleteProjectById(id);
    }

    //UPDATE PROJECT BY ID
    @PostMapping(AdminAboutMePaths.UPDATE_PROJECT_BY_ID + "{id}")
    public ResponseEntity<Project> updateProjectById(@PathVariable(value = "id")Long id, @RequestBody Project project) {
        return ResponseEntity.ok(aboutMeServiceByAdmin.updateProjectById(id, project));
    }












}
