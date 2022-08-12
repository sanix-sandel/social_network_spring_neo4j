package com.neo.spring_neo.services;

import com.neo.spring_neo.entity.Page;
import com.neo.spring_neo.repositories.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService{

    private final PageRepository pageRepository;

    @Override
    public List<Page> userFollowedPages(Long userId) {
        return pageRepository.findFollowedPage(userId);
    }
}
