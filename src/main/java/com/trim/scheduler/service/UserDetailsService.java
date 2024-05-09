package com.trim.scheduler.service;

import com.trim.scheduler.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    User loadUserByName(String username) throws UsernameNotFoundException;
}