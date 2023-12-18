package com.bp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.UserRepository;
import com.bp.dao.entity.User;
import com.bp.model.AuthDTO;
import com.bp.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
	JwtService jwtService;

    @Override
    public AuthDTO authenticateUser(UserDTO userDTO) {
    	AuthDTO authDTO = new AuthDTO();
        User fetchedUser = userRepository.findByUserNameAndUserPassword(userDTO.getUserName(),userDTO.getUserPassword());

        if (fetchedUser!=null) {
            userDTO.setUserId(fetchedUser.getUserId());
            userDTO.setRole(fetchedUser.getRole());
            authDTO.setUserDTO(userDTO);
            authDTO.setToken(jwtService.generateToken(userDTO));
        } else {
            throw new RuntimeException("Invalid Username/password!");
        }

        return authDTO;
    }

	@Override
	public UserDTO createUser(UserDTO userDTO) {
        User fetchedUser = userRepository.findByUserName(userDTO.getUserName());
        
        if (fetchedUser==null) {
        	User user = new User();
        	BeanUtils.copyProperties(userDTO, user);
        	userRepository.saveAndFlush(user);
        	BeanUtils.copyProperties(user, userDTO);
        } else {
            throw new RuntimeException("Username alredy exists!");
        }

        return userDTO;
	}
}
