package com.subash.api.service;

import com.subash.api.model.Token;
import com.subash.api.model.User;

public interface RegisterService {

	public void addRegister(User register);

	public void addToken(Token token);

	public boolean checkCredentials(String email, String password);

	public boolean isTokenValid(String randomvalues);

	public void deleteToken(String randomvalue);
	
	public String findRole(String email);
	
	public String findCompanyName(String email);
	
	public int findPatientId(String email);
	
	public User getJewellery(int id);
	
	public void updatePassword(int id,String password);
	
	public String findSchoolEmailAddress();
	
	public String findCollegeEmailAddress();

}
