package com.dvmena.gadget_finder1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {
    @GetMapping("/connection/{dummy}")
    public String dummyConnection(@PathVariable String dummy){
        return "";
    }
}
