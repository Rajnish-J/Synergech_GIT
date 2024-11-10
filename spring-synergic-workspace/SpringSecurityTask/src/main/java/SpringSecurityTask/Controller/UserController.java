package SpringSecurityTask.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringSecurityTask.BO.UserBusiness;
import SpringSecurityTask.Entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserBusiness userBusiness;

	@GetMapping("/{username}")
	public Optional<User> getUserByUsername(@PathVariable String username) {
		return userBusiness.getUserByUsername(username);
	}

	@GetMapping("/admin")
	public String adminAccess() {
		return "This is the admin page";
	}

	@GetMapping("/user")
	public String userAccess() {
		return "This is the user page";
	}
}
