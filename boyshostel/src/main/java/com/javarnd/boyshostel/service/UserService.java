package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.boyshostel.model.UserDetails;

public interface UserService {

	public void insert(UserDetails userDetails) throws SQLException;

	public void delete(UserDetails userDetails) throws SQLException;

	public UserDetails findById(int userId) throws SQLException;

	public List<UserDetails> findAll() throws SQLException;

	public List<UserDetails> findByName(String name) throws SQLException;

	public UserDetails checkAuthentication(String email, String password) throws SQLException;

}
