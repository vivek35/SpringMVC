package com.first.firstservice;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean authenticate(String username,String password) {
		System.out.println("Coming in authenticate");
		if(username.equals("Vivek@gmail.com") && password.equals("Vivek1234")) {
			return true;
		}else {
			return false;
		}
	}
}
