package com.sampana.cms.service;

import java.util.List;

import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.model.ResponseDTO;
import com.sampana.cms.model.User;

//@Service("userService")
public interface UserService {

	/*
	 * private UserRepository userRepository; private RoleRepository roleRepository;
	 * 
	 * public User findUserByEmail(String email) { return
	 * userRepository.findByEmail(email); }
	 */

	public List<User> getUsers(long id);

	public void createUser(User user);

	public List<User> getUser();


	public ResponseDTO saveUser(UserDTO userDTO);

	

}