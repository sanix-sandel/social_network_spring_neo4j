package com.neo.spring_neo.bootstrap;

import com.neo.spring_neo.entity.Follow;
import com.neo.spring_neo.entity.Page;
import com.neo.spring_neo.entity.Person;
import com.neo.spring_neo.repositories.FollowingRepository;
import com.neo.spring_neo.repositories.PageRepository;
import com.neo.spring_neo.repositories.UserRepository;
import com.neo.spring_neo.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PageRepository pageRepository;
    private final UserRepository userRepository;
    private final FollowingRepository followingRepository;
    private final PageService pageService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Person person=new Person();
        person.setName("Sanick");
        Person person1=userRepository.save(person);

        Page page=new Page();
        page.setName("Life");
        Page page1=pageRepository.save(page);

        Follow follow=new Follow();
        follow.getPages().add(page1);

        Follow follow1=followingRepository.save(follow);

        person1.getFollows().add(follow1);
        userRepository.save(person1);

        System.out.println(pageService.userFollowedPages(person1.getId()));

        for(Person person2:userRepository.findAll()){
            System.out.println(person2);
        }
        for(Follow follow2:followingRepository.findAll()){
            System.out.println(follow2);
        }


    }

}
