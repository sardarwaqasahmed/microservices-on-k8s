package com.demo.stakater.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class DemoBEController {


    @GetMapping(value = "/hello")
    @Operation(summary = "Get hello ${name}. Retrieved name from env Variable")
    @ResponseBody
    public ResponseEntity<String> getHelloStakater() {
        return ResponseEntity.ok("hello waqas");
    }
}
