package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.authentication;

import lombok.RequiredArgsConstructor;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.security.JwtService;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Role;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstname())
                .LastName(request.getLastname())
                ///todo: CHANGE!! camelCasing
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(); //todo: catch exception later on

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
