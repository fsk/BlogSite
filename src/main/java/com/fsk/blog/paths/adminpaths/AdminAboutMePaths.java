package com.fsk.blog.paths.adminpaths;

public final class AdminAboutMePaths {

    private AdminAboutMePaths(){}

    public static final String MANAGE_CAREER = "/manage-career";

    /**
     * EXPERIENCE
     */
    public static final String GET_ALL_EXPERIENCES = "/get-all-experiences";

    public static final String GET_EXPERIENCE_BY_COMPANY_NAME = "/get-experience-by-company-name/";

    public static final String GET_EXPERIENCE_BY_ID = "/get-experience-by-id/";

    public static final String DELETE_EXPERIENCE_BY_ID = "/delete-experience-by-id/";

    public static final String DELETE_EXPERIENCE_BY_COMPANY_NAME = "/delete-experience-by-company-name/";

    public static final String INSERT_EXPERIENCE = "/insert-experience";

    public static final String UPDATE_EXPERIENCE_BY_ID = "/update-experience-by-id/";

    public static final String UPDATE_EXPERIENCE_BY_COMPANY_NAME = "/update-experience-by-company-name/";


    //------------------------------------------------------------------------------------------------------------------


    /**
     *  CONFERENCES
     */

    public static final String GET_ALL_CONFERENCES = "/get-all-conferences";

    public static final String GET_CONFERENCE_BY_ID =  "/get-conference-by-id/";

    public static final String DELETE_CONFERENCE_BY_ID = "/delete-conference-by-id/";

    public static final String INSERT_CONFERENCE = "/insert-conference";

    public static final String UPDATE_CONFERENCE_BY_ID = "/update-conference-by-id/";


    //------------------------------------------------------------------------------------------------------------------


    /**
     * CONTACT
     */

    public static final String GET_CONTACT_INFORMATION = "/get-contact-information";

    public static final String UPDATE_CONTACT_INFORMATION = "/update-contact-information";


    //------------------------------------------------------------------------------------------------------------------


    /**
     * REFERENCES
     */

    public static final String INSERT_REFERENCE = "/insert-reference";

    public static final String GET_ALL_REFERENCES = "/get-all-references";

    public static final String GET_REFERENCE_BY_ID = "/get-reference-by-id/";

    public static final String GET_REFERENCE_BY_NAME_AND_SURNAME = "/get-reference-by-name-and-surname/";

    public static final String DELETE_REFERENCE_BY_ID = "/delete-reference-by-id/";

    public static final String DELETE_REFERENCE_BY_NAME_AND_SURNAME = "/delete-reference-by-name-and-surname/";

    public static final String UPDATE_REFERENCE_BY_ID = "/update-reference-by-id/";

    public static final String UPDATE_REFERENCE_BY_NAME_AND_SURNAME = "/update-reference-by-name/";


    //------------------------------------------------------------------------------------------------------------------


    /**
     * PROJECT
     */

    public static final String INSERT_PROJECT = "/insert-project";

    public static final String GET_ALL_PROJECTS = "/get-all-projects";

    public static final String GET_PROJECT_BY_ID = "/get-project-by-id/";

    public static final String DELETE_PROJECT_BY_ID = "/delete-project-by-id/";

    public static final String UPDATE_PROJECT_BY_ID = "/update-project-by-id/";


}
