package ru.otus.softwarearchitect.defimov.telecomgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Controller {
    @GetMapping(value = "/")
    public String getHello() {
        return "Hello world!";
    }
}
