package com.javarnd.boyshostel.service;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.boyshostel.model.Report;

public interface ReportService {

	public void insert(Report report) throws SQLException;

	public void delete(Report report) throws SQLException;

	public Report findById(int reportId) throws SQLException;

	public List<Report> findAll() throws SQLException;

}
