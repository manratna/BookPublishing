package com.bp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.UserRepository;
import com.bp.dao.entity.User;
import com.bp.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO authenticateUser(UserDTO userDTO) {
        User fetchedUser = userRepository.findByUserNameAndUserPassword(userDTO.getUserName(),userDTO.getUserPassword());

        if (fetchedUser!=null) {
            userDTO.setUserId(fetchedUser.getUserId());
            userDTO.setRole(fetchedUser.getRole());
        } else {
            throw new RuntimeException("Invalid Username/password!");
        }

        return userDTO;
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
