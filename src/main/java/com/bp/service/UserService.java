package com.bp.service;

import com.bp.model.AuthDTO;
import com.bp.model.UserDTO;

public interface UserService {
	
	public AuthDTO authenticateUser(UserDTO userDTO);

	public UserDTO createUser(UserDTO userDTO);
}
