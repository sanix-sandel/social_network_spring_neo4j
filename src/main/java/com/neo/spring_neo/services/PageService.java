package com.neo.spring_neo.services;

import com.neo.spring_neo.entity.Page;

import java.util.List;

public interface PageService {

    List<Page>getAll();

    List<Page>userFollowedPages(Long userId);

    List<Page>recommendedPages(Long userId);
}
