package com.ddori.service.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    @GetMapping("/api/users/{id}")
    public String findById(@PathVariable Long id) {
        return String.format("ID = %d",id);
    }
}
