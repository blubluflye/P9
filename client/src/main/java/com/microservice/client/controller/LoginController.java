package com.microservice.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	private final AuthenticationManager authenticationManager;

	public LoginController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/loginPage")
	public ResponseEntity<Authentication> login(@RequestBody LoginRequest loginRequest) {
		System.out.println("entre dans le endpoint login");
		Authentication authenticationRequest =
			UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());
		Authentication authenticationResponse =
			this.authenticationManager.authenticate(authenticationRequest);
		// ...
		return ResponseEntity.ok(authenticationResponse);
	}

	public record LoginRequest(String username, String password) {
	}

}
