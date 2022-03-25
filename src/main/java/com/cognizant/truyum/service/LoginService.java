package com.cognizant.truyum.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.LoginData;

@Service
public class LoginService {

	private Map<String, String> loginData = new HashMap<>();

	public Map<String, String> getLoginData() {
		return loginData;
	}

	public LoginService() {
		loginData.put("Dhinesh", "Daylord@1");
		loginData.put("Ganesh", "Daylord@G");
	}

	public boolean validate(LoginData login) {
		Set<String> keySet=loginData.keySet();
		for (String user : keySet) {
			if(user.equals(login.getUserName())&&loginData.get(user).equals(login.getPassword())){
				return true;
			}
		}
		return false;
	}
}
