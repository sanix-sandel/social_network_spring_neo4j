package com.neo.spring_neo.controller;

import com.neo.spring_neo.entity.Page;
import com.neo.spring_neo.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("pages")
public class PageController {

    private final PageService pageService;

    @GetMapping("")
    public ResponseEntity<List<Page>>getPages(){
        return ResponseEntity.ok(pageService.getAll());
    }

    @GetMapping("favourites/{userId}")
    public ResponseEntity<List<Page>>getFollowedPages(@PathVariable("userId")Long userId){
        return ResponseEntity.ok(pageService.userFollowedPages(userId));
    }

    @GetMapping("recommended/{userId}")
    public ResponseEntity<List<Page>>getRecommendedPages(@PathVariable("userId")Long userId){
        return ResponseEntity.ok(pageService.recommendedPages(userId));
    }


}
