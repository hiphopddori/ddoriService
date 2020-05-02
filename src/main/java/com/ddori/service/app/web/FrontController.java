package com.ddori.service.app.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

    public FrontController () {
        logger.info("create FrontController");
    }
    @GetMapping("/")
    public String index() {
        logger.info("root call");
        return "index.html";
    }
    @GetMapping("/test2")
    public String login() {
        logger.info("login call");
        return "/login";
    }
}
