package com.javarnd.boyshostel.resources;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javarnd.boyshostel.model.UserDetails;
import com.javarnd.boyshostel.service.UserService;

@RestController
@RequestMapping(HomeController.BASE_URI)
public class HomeController {

	protected static final String BASE_URI = "/api/v1/";

	@Autowired
	private UserDetails userDetails;

	@Autowired
	private UserService userDao;

	@GetMapping("/index")
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView("index");

		mav.addObject("login", "login");
		mav.addObject("register", "register");

		return mav;

	}

	@GetMapping("/login")
	public ModelAndView loginView() {

		ModelAndView mav = new ModelAndView("login");

		mav.addObject("userDetails", userDetails);

		return mav;

	}

	@GetMapping("/home")
	public ModelAndView welcome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home");

		mav.addObject("registerstudent", "registerstudent");
		mav.addObject("updatestudent", "updatestudent");
		mav.addObject("viewallstudents", "viewallstudents");
		// mav.addObject("logout", "logout");
		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {

		HttpSession session = request.getSession();

		ModelAndView mav = new ModelAndView("home");
		request.getSession(false);

		session.invalidate();

		return mav;

	}

	@GetMapping("/register")
	public ModelAndView registerView() {

		ModelAndView mav = new ModelAndView("register");

		mav.addObject("userDetails", userDetails);
		return mav;

	}

	@GetMapping("/registerstudent")
	public ModelAndView registerStudent() {

		ModelAndView mav = new ModelAndView("registerstudent");

		mav.addObject("userDetails", userDetails);

		return mav;

	}

	@PutMapping("students/{userId}")
	public ResponseEntity<UserDetails> updateForm(@PathVariable("userId") int userId, @RequestBody UserDetails user)
			throws SQLException {
		userDetails = userDao.findById(userId);

		if (userDetails == null) {

			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);

		} else {
			userDetails.setUserName(user.getUserName());
			userDetails.setContactNo(user.getContactNo());
			userDetails.setAddress(user.getAddress());
			userDetails.setEmail(user.getEmail());
			userDetails.setPassword(user.getPassword());

			userDao.insert(userDetails);
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		}

	}

	// @GetMapping(value="students", produces=MediaType.APPLICATION_JSON_VALUE,
	// consumes=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("students")
	public ResponseEntity<List<UserDetails>> viewAllStudents() throws SQLException {
		List<UserDetails> listUsers = userDao.findAll();

		if (listUsers.isEmpty()) {
			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<List<UserDetails>>(listUsers, HttpStatus.OK);
		}
	}

	@GetMapping("students/{userId}")
	public ResponseEntity<UserDetails> viewById(@PathVariable("userId") int userId) throws SQLException {

		userDetails = userDao.findById(userId);

		if (userDetails == null) {

			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);

	}

	@DeleteMapping("students/{userId}")
	public ResponseEntity<UserDetails> deleteById(@PathVariable("userId") int userId) throws SQLException {

		userDetails = userDao.findById(userId);
		userDetails.setUserId(userId);
		
		if (userDetails == null) {
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}

		userDao.delete(userDetails);
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
	}

}
