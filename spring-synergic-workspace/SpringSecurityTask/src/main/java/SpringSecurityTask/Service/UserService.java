package SpringSecurityTask.Service;

import java.util.Optional;

import SpringSecurityTask.Entity.User;

public interface UserService {
	Optional<User> findByUsername(String username);
}
