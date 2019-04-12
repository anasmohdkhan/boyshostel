package com.javarnd.boyshostel.dao;

import java.sql.SQLException;

import com.javarnd.boyshostel.model.Student;

public interface StudentDao {

	public void insert(Student student) throws SQLException;

	public void delete(Student student) throws SQLException;

}
