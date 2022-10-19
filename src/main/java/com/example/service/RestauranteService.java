package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.RestauranteRepository;

@Service
public class RestauranteService {
	@Autowired
	private RestauranteRepository userDAO;
	
	public String register(String jso) {
		/*User user = new User();
		user.setUserName(jso.getString("userName"));
		user.setEmail(jso.getString("email"));
		user.setPwd(jso.getString("pwd1"));
		user.setToken(UUID.randomUUID().toString());
		user.setHora(System.currentTimeMillis());
		this.userDAO.save(user);
		return user.getToken();*/
		return null;
	}
}
