package com.trim.scheduler.service;

import com.trim.scheduler.mapper.UserMapper;
import com.trim.scheduler.model.User;
import com.trim.scheduler.repository.UserRepository;
import com.trim.scheduler.utils.ApiException;
import com.trim.scheduler.utils.ErrorConstants;
import com.trim.scheduler.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findByEmailOrThrow(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
            new ApiException("Something went wrong", ErrorConstants.UNKNOWN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
