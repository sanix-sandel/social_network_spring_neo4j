package com.neo.spring_neo.services;

import com.neo.spring_neo.entity.Person;

import java.util.List;

public interface UserService {

    List<Person>recommendedFriends(Long userId);
}
