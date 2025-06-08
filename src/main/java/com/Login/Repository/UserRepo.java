package com.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Login.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
