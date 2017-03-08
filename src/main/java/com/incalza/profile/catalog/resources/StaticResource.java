package com.incalza.profile.catalog.resources;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticResource {

    @GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
    public Resource index() {
        return new ClassPathResource("static/sse-node.html");
    }

    @GetMapping(path = "/maps", produces = MediaType.TEXT_HTML_VALUE)
    public Resource maps() {
        return new ClassPathResource("static/maps.html");
    }
}