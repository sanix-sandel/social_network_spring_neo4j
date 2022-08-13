package com.neo.spring_neo.services;

import com.neo.spring_neo.entity.Person;
import com.neo.spring_neo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<Person> recommendedFriends(Long userId) {
        return userRepository.findFriendOfFriend(userId);
    }
}
