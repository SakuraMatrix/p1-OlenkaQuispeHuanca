package com.github.olenkaqh.p1.service;

import com.github.olenkaqh.p1.domain.User;
import com.github.olenkaqh.p1.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Flux<User> getAll(){
        return userRepository.getAll();
    }
    public Mono<User> get(String id){
        return userRepository.get(Integer.parseInt(id));
    }

    public User addUser(User user) {
        return userRepository.create(user);
    }
}
