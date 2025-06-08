package com.Login.Service;

import java.util.List;

import com.Login.Entity.User;

public interface UserService {
	void save(User u);
	List<User> getAllStudent();
}
