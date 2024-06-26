package com.trim.scheduler.service;

import com.trim.scheduler.model.UserDetailsImpl;
import com.trim.scheduler.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      var user = userRepository.findByEmail(email)
          .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

      return UserDetailsImpl.build(user);
    }
}