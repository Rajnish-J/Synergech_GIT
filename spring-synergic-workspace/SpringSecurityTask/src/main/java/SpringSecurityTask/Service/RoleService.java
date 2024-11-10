package SpringSecurityTask.Service;

import java.util.Optional;

import SpringSecurityTask.Entity.Role;

public interface RoleService {
	Optional<Role> findByName(String name);

	Role save(Role role);
}
