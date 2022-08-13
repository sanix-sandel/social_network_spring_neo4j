package com.neo.spring_neo.services;

import com.neo.spring_neo.entity.Page;

import java.util.List;

public interface PageService {

    List<Page>userFollowedPages(Long id);

    List<Page>recommendedPages(Long userId);
}
