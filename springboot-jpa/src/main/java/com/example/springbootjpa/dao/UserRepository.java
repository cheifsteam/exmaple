package com.example.springbootjpa.dao;

import com.example.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
