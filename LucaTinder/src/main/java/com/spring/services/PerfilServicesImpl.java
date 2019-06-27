package com.ejemplos.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.dao.UserRepository;
import com.ejemplos.spring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDAO;

	/*
	 * public UserServiceImpl(){
	 * 
	 * }
	 * 
	 * public UserServiceImpl(UserDAO userDAO) { super(); this.userDAO =
	 * userDAO; }
	 */

	@Override
	public List<User> list() {

		return userDAO.findAll();
	}

	@Override
	public User get(int id) {
		return userDAO.findOne(id);
	}

	@Override
	public void update(User user) {
		userDAO.save(user);
	}

	@Override
	public void add(User user) {
		userDAO.save(user);
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
	}

}
