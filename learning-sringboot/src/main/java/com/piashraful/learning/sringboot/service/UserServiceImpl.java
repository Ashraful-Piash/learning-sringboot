package com.piashraful.learning.sringboot.service;

import com.piashraful.learning.sringboot.entity.Product;
import com.piashraful.learning.sringboot.entity.User;
import com.piashraful.learning.sringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
}
