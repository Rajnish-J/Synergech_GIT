package com.Amount_Transaction.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Amount_Transaction.Entity.UserVO;
import com.Amount_Transaction.Exception.InValidDateException;
import com.Amount_Transaction.Exception.InvalidEmailException;
import com.Amount_Transaction.Exception.NameException;
import com.Amount_Transaction.Exception.PasswordException;
import com.Amount_Transaction.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userSer;

	@PostMapping("/bulk-insert")
	public ResponseEntity<?> bulkInsert(@RequestBody List<UserVO> users) {
		try {
			userSer.bulkInsert(users);
		} catch (InValidDateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (NameException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (InvalidEmailException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PasswordException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.ok("Users Details are inseted Sucessfully !!!");

	}

}
