package com.neo.spring_neo.bootstrap;

import com.neo.spring_neo.entity.*;
import com.neo.spring_neo.repositories.PageRepository;
import com.neo.spring_neo.repositories.PostRepository;
import com.neo.spring_neo.repositories.TagRepository;
import com.neo.spring_neo.repositories.UserRepository;
import com.neo.spring_neo.services.PageService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PageRepository pageRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final PageService pageService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Person person=new Person();
        person.setName("nixa");
        Person person2=new Person();
        person2.setName("Jesna");
        person=userRepository.save(person);
        person2=userRepository.save(person2);



        Page page=new Page();
        page.setName("FORBES");
        Page page1=pageRepository.save(page);

        Page page2=new Page();
        page2.setName("ESPN");
        pageRepository.save(page2);

        Page page3=new Page();
        page3.setName("TIME");
        pageRepository.save(page3);

        Page page4=new Page();
        page4.setName("Inc");
        pageRepository.save(page4);

        Page page5=new Page();
        page5.setName("Life");
        pageRepository.save(page);

        Follow follow2=new Follow();
        follow2.setPage(page2);
        person2.getFollows().add(follow2);
//        userRepository.save(person2);


        Follow follow21=new Follow();
        follow21.setPage(page3);
        person2.getFollows().add(follow21);
//        userRepository.save(person2);

        Follow follow22=new Follow();
        follow22.setPage(page5);
        person2.getFollows().add(follow22);

        userRepository.save(person2);

        Follow follow=new Follow();
        follow.setPage(page1);
        //Follow follow1=followingRepository.save(follow);

        FriendWith friendWith=new FriendWith();
        friendWith.setFriendTo(person2);

        person.getFollows().add(follow);
        userRepository.save(person);

        Follow follow1=new Follow();
        follow1.setPage(page4);
        person.getFollows().add(follow1);

        userRepository.save(person);

        Follow follow11=new Follow();
        follow11.setPage(page5);
        person.getFollows().add(follow11);
        userRepository.save(person);


        person.getFriendTo().add(friendWith);

        userRepository.save(person);


        System.out.println(pageService.userFollowedPages(person.getId()));

        System.out.println(pageService.recommendedPages(person.getId()));

        FriendWith friendWith1=new FriendWith();
        friendWith1.setFriendTo(person2);

        Person person3=new Person();
        person3.setName("Neldie");
        person3.getFriendTo().add(friendWith1);
//        person3.getFollows().add(follow22);
        userRepository.save(person3);


        FriendWith friendWith2=new FriendWith();
        friendWith2.setFriendTo(person2);
        Person person4=new Person();
        person4.setName("Ruth");
        person4.getFriendTo().add(friendWith2);
//        person4.getFollows().add(follow21);
//        person4.getFollows().add(follow11);
        userRepository.save(person4);

        Tag tag=new Tag();
        tag.setName("business");
        tagRepository.save(tag);

        Tag tag1=new Tag();
        tag1.setName("Tech");
        tagRepository.save(tag1);

        Post post=new Post();
        post.setContent("Sandel Ikani, The new one !");
        post.getTagList().add(tag);
        post.getTagList().add(tag1);
        Post createdPost=postRepository.save(post);

        createdPost.getLikers().add(person4);
        postRepository.save(createdPost);

        page.getPosts().add(createdPost);
        pageRepository.save(page);




//
//        userRepository.deleteAll();
//        pageRepository.deleteAll();
//        postRepository.deleteAll();
//        tagRepository.deleteAll();

//
//        for(Person person2:userRepository.findAll()){
//            System.out.println(person2);
//        }
//        for(Follow follow2:followingRepository.findAll()){
//            System.out.println(follow2);
//        }


    }

}
