package com.example.springsecurituy.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurituy.entity.MyUserDetails;
import com.example.springsecurituy.entity.User;
import com.example.springsecurituy.repo.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user= userRepository.findByName(username);
		
		user.orElseThrow(()->new UsernameNotFoundException("Not found: "+username));
		return user.map(MyUserDetails::new).get();
	}

}
