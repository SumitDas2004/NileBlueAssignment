package com.nileblue.assignment.userservice.dao;

import com.nileblue.assignment.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
