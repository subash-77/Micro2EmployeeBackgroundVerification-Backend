package com.subash.api.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.subash.api.model.Token;
import com.subash.api.model.User;
import com.subash.api.ownrepo.RegisterOwnRepo;

import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.subash.api.model.Token;
import com.subash.api.model.User;
import com.subash.api.ownrepo.RegisterOwnRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

class RegisterServiceImplTest {

	@InjectMocks
	private RegisterServiceImpl registerService;

	@Mock
	private RegisterOwnRepo ownrepo;

	private User sampleUser;
	private Token sampleToken;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);

	        sampleUser = new User();
	        sampleUser.setUserId(1);
	        sampleUser.setEmail("john.doe@example.com");
	        sampleUser.setPassword("password");
	        sampleUser.setRole("User");
	        sampleUser.setCompanyName("school");

	        sampleToken = new Token();
	        sampleToken.setToken("sample-token");
	        sampleToken.setRandomValue("random-value");
	        //sampleToken.setExpirationDate(new Date(System.currentTimeMillis() + 3600 * 1000)); // 1 hour from now
	    }

	@Test
	void testAddRegister() {
		doNothing().when(ownrepo).save(sampleUser);

		registerService.addRegister(sampleUser);

		// verify(ownrepo, times(1)).save(sampleUser);
	}

	

	@Test
	void testAddToken() {
		doNothing().when(ownrepo).saveToken(sampleToken);

		registerService.addToken(sampleToken);

		// verify(ownrepo, times(1)).saveToken(sampleToken);
	}









}
