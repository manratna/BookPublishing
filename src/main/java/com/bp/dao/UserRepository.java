package com.bp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserNameAndUserPassword(String userName, String userPassword);
    User findByUserName(String userName);
}
