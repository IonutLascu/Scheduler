package com.trim.scheduler.service;

import com.trim.scheduler.domain.api.AuthenticationRequest;
import com.trim.scheduler.domain.api.AuthenticationResponse;
import com.trim.scheduler.domain.api.RegistrationRequest;
import com.trim.scheduler.enums.ERole;
import com.trim.scheduler.model.User;
import com.trim.scheduler.repository.RoleRepository;
import com.trim.scheduler.repository.UserRepository;
import com.trim.scheduler.utils.ApiException;
import com.trim.scheduler.utils.ErrorConstants;
import com.trim.scheduler.utils.JwtUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ApiException("Something went wrong", ErrorConstants.UNKNOWN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ApiException("Invalid credentials", ErrorConstants.INVALID_CREDENTIALS, HttpStatus.BAD_REQUEST);
        }

        String token = jwtUtils.generateTokenFromEmail(user.getEmail());
        return new AuthenticationResponse(token);
    }

    @Transactional
    public void register(RegistrationRequest request) {
        var userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isPresent()) {
            throw new ApiException("Something went wrong", ErrorConstants.UNKNOWN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String encryptedPassword = passwordEncoder.encode(request.getPassword());

        var userRoleOpt = roleRepository.findByName(ERole.ROLE_USER);
        if (userRoleOpt.isEmpty()) {
            throw new ApiException("Something went wrong", ErrorConstants.UNKNOWN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        var user = User.builder()
            .phoneNumber(request.getPhoneNumber())
            .name(request.getName())
            .email(request.getEmail())
            .password(encryptedPassword)
            .roles(Set.of(userRoleOpt.get()))
            .build();

        userRepository.save(user);
    }
}
