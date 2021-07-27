package com.fsk.blog.controllers.usercontroller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/cv")
public class CVController {

    private static final String FILE_LOCATION = "D:\\JAVA\\Blog\\src\\main\\resources\\furkan_sahin_kulaksiz_cv.pdf";

    @GetMapping(value = "/download-fsk-cv")
    public InputStreamResource fileSystemResource(HttpServletResponse response) throws IOException {
        response.setContentType("fsk/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"furkan_sahin_kulaksiz_cv.pdf\"");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(FILE_LOCATION));
        return resource;
    }
}
