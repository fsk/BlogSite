package com.fsk.blog.controllers.usercontroller;

import com.fsk.blog.entities.*;
import com.fsk.blog.paths.userpaths.UserAboutMePaths;
import com.fsk.blog.services.userservice.AboutMeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(UserAboutMePaths.USER_ABOUT_ME + "/" + UserAboutMePaths.USER_WELCOME)
@RequiredArgsConstructor
@Api(value = "This Controller for Users")
public class AboutMeController {

    private final AboutMeService aboutMeService;

    @GetMapping(value = UserAboutMePaths.USER_FSK)
    @ApiOperation(value = "Base Controller", notes = "This Api base Controller")
    public ResponseEntity<Furkan> welcomeToMyWorld(){
        return ResponseEntity.ok(aboutMeService.getMyWorld());
    }

    @GetMapping(value = UserAboutMePaths.USER_UNIVERSITY)
    public ResponseEntity<University> getUniversity(){
        return ResponseEntity.ok(aboutMeService.getUniversity());
    }

    @GetMapping(value = UserAboutMePaths.USER_MASTER_DEGREE)
    public ResponseEntity<MasterDegree> getMasterDegree(){
        return ResponseEntity.ok(aboutMeService.getMasterDegree());
    }

    @GetMapping(value = UserAboutMePaths.USER_GET_ALL_EXPERIENCES)
    public ResponseEntity<List<Experience>> getAllExperiences(){
        return ResponseEntity.ok(aboutMeService.getAllExperiences());
    }

    @GetMapping(value = UserAboutMePaths.USER_GET_ALL_PROJECTS)
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(aboutMeService.getAllProjects());
    }

    @GetMapping(value = UserAboutMePaths.USER_GET_ALL_CONFERENCES)
    public ResponseEntity<List<Conference>> getAllConferences() {
        return ResponseEntity.ok(aboutMeService.getAllConferences());
    }

    @GetMapping(value = UserAboutMePaths.USER_GET_ALL_REFERENCES)
    public ResponseEntity<List<Reference>> getAllReferences() {
        return ResponseEntity.ok(aboutMeService.getAllReferences());
    }



}
