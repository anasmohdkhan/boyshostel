package com.javarnd.boyshostel.resources;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.javarnd.boyshostel.model.Student;
import com.javarnd.boyshostel.model.UserDetails;
import com.javarnd.boyshostel.service.StudentService;
import com.javarnd.boyshostel.service.UserService;

@RestController
public class ActionController {

	protected static final String BASE_URI = "/api/v1/";

	@Autowired
	private UserDetails userDetails;

	@Autowired
	private UserService userDao;

	@Autowired
	private Student student;

	@Autowired
	private StudentService studentDao;

	@PostMapping
	public ResponseEntity<Void> register(@RequestBody UserDetails userDetails, UriComponentsBuilder ucBuilder)
			throws SQLException {

		userDao.insert(userDetails);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("students/{userId}").buildAndExpand(userDetails.getUserId()).toUri());

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/checkAuthentication", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView login(HttpServletRequest request) throws SQLException {

		HttpSession session = request.getSession();

		ModelAndView mav = new ModelAndView();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		userDetails.setEmail(email);
		userDetails.setPassword(password);

		userDetails = userDao.checkAuthentication(email, password);

		mav.addObject("userDetails", userDetails);
		mav.setViewName("redirect:home");

		session.setAttribute("userDetails", userDetails);
		mav.addObject("userDetails", userDetails);

		return mav;
	}

	@PostMapping(value = "/savestudent", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView saveStudent(HttpServletRequest request) throws SQLException {
		ModelAndView mav = new ModelAndView();

		String userName = request.getParameter("userName");
		String contactNo = request.getParameter("contactNo");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String courseName = request.getParameter("courseName");
		String courseDuration = request.getParameter("courseDuration");

		student.setUserName(userName);
		student.setContactNo(contactNo);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);
		student.setCourseName(courseName);
		student.setCourseDuration(courseDuration);

		mav.addObject("student", student);

		studentDao.insert(student);
		mav.setViewName("home");

		return mav;

	}
}
