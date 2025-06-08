package com.Login.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Login.Entity.User;
import com.Login.Repository.UserRepo;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo repo ;
	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}
	@Override
	public List<User> getAllStudent() {
		// TODO Auto-generated method stub
		return 	repo.findAll();
	}


}
