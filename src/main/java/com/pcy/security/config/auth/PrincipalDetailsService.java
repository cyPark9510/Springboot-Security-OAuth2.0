package com.pcy.security.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pcy.security.model.User;
import com.pcy.security.repository.UserRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService/loadUserByUsername");
		User user = userRepository.findByUsername(username);
		if (user == null) {
			return null;
		} else {
			return new PrincipalDetails(user);
		}

	}

}