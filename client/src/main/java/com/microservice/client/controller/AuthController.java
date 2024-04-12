package com.microservice.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.client.configuration.JwtProvider;
import com.microservice.client.dto.AuthResponse;
import com.microservice.client.dto.LoginRequest;

@RestController
public class AuthController {
	@GetMapping("/sigin")
	public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticate(loginRequest.getUsername(),loginRequest.getPassword()); 
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = JwtProvider.generateToken(authentication); 
        AuthResponse authResponse = new AuthResponse(); 
  
        authResponse.setMessage("Login success"); 
        authResponse.setJwt(token); 
        authResponse.setStatus(true); 
  
        return new ResponseEntity<>(authResponse,HttpStatus.OK); 
    }

	private Authentication authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
