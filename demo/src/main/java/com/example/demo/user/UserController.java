package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello/no")
    public String hello(){
        return "hello";
    }

    @PostMapping("users/create")
    public @ResponseBody User create(@RequestBody User user) {
        return user;
    }
}
