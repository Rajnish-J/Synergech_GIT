package SpringSecurityTask.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

	// Implement the loadUserByUsername method
	@Override
	public UserDetails loadUserByUsername(String username) {
		// Fetch user from the database (simulating here with hardcoded user)
		// In real use, replace with actual database fetching logic

		if ("admin".equals(username)) {
			return User.builder().username("admin").password("{noop}admin123") // Use {noop} to indicate no encryption
																				// for demo purposes
					.roles("ADMIN").build();
		} else if ("user".equals(username)) {
			return User.builder().username("user").password("{noop}user123").roles("USER").build();
		} else {
			throw new UsernameNotFoundException("User not found");
		}
	}
}
