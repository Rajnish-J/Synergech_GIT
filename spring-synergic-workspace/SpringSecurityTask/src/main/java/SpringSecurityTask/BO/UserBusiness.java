package SpringSecurityTask.BO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringSecurityTask.Entity.User;
import SpringSecurityTask.Service.UserService;

@Component
public class UserBusiness {

	@Autowired
	private UserService userService;

	public Optional<User> getUserByUsername(String username) {
		return userService.findByUsername(username);
	}
}
