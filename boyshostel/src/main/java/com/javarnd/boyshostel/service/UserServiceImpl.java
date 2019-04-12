package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.boyshostel.dao.UserDetailsDao;
import com.javarnd.boyshostel.model.UserDetails;

/**
 * @author Anas This is Service Layer For User Operations
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDetails userDetails;
	@Autowired
	private UserDetailsDao userDao;

	@Override
	public void insert(UserDetails userDetails) throws SQLException {

		userDao.insert(userDetails);

	}

	@Override
	public void delete(UserDetails userDetails) throws SQLException {

		userDao.delete(userDetails);

	}

	@Override
	public UserDetails findById(int userId) throws SQLException {

		userDetails = userDao.findById(userId);

		return userDetails;
	}

	@Override
	public List<UserDetails> findAll() throws SQLException {

		List<UserDetails> listUser = new ArrayList<UserDetails>();
		listUser = userDao.findAll();
		return listUser;
	}

	@Override
	public List<UserDetails> findByName(String name) throws SQLException {

		List<UserDetails> listUser = new ArrayList<UserDetails>();
		listUser = userDao.findByName(name);

		return listUser;

	}

	@Override
	public UserDetails checkAuthentication(String email, String password) throws SQLException {

		userDetails = userDao.checkAuthentication(email, password);

		return userDetails;
	}

}
