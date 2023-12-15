package com.bp.service;

import com.bp.model.UserDTO;

public interface UserService {
	
	public UserDTO authenticateUser(UserDTO userDTO);

	public UserDTO createUser(UserDTO userDTO);
}
