package com.subash.api.serviceimpl;


import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.subash.api.model.Token;
import com.subash.api.model.User;
import com.subash.api.ownrepo.RegisterOwnRepo;
import org.mockito.MockitoAnnotations;

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
	       
	    }

	@Test
	void testAddRegister() {
		doNothing().when(ownrepo).save(sampleUser);

		registerService.addRegister(sampleUser);
	}

	

	@Test
	void testAddToken() {
		doNothing().when(ownrepo).saveToken(sampleToken);

		registerService.addToken(sampleToken);

	}

}
