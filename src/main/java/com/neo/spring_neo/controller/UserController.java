package com.neo.spring_neo.controller;

import com.neo.spring_neo.entity.Person;
import com.neo.spring_neo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

//    @GetMapping("friends/{userId}")
//    public ResponseEntity<List<Person>>getFriends(@PathVariable("userId")Long userId){
//        return ResponseEntity.ok();
//    }

    @GetMapping("recommended-friends/{userId}")
    public ResponseEntity<List<Person>>recommendedFriends(@PathVariable("userId")Long userId){
        return ResponseEntity.ok(userService.recommendedFriends(userId));
    }



}
