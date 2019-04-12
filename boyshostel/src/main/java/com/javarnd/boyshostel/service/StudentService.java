package com.javarnd.boyshostel.service;

import java.sql.SQLException;

import com.javarnd.boyshostel.model.Student;

public interface StudentService {

	public void insert(Student student) throws SQLException;

	public void delete(Student student) throws SQLException;

}
