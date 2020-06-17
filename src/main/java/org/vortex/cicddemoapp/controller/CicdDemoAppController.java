package org.vortex.cicddemoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class CicdDemoAppController {

    private static final String template = "Hello, %s!";

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("---------->");
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            return new StringBuilder().append("Hello ").append(name).append("...!, From: ").append(ip).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
