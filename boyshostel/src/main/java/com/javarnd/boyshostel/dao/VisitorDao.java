package com.javarnd.boyshostel.dao;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.boyshostel.model.Visitor;

public interface VisitorDao {

	public void insert(Visitor visitor) throws SQLException;

	public List<Visitor> findAll() throws SQLException;

}
