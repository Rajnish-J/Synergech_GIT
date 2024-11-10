package SpringSecurityTask.BO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringSecurityTask.Entity.Role;
import SpringSecurityTask.Service.RoleService;

@Component
public class RoleBusiness {

	@Autowired
	private RoleService roleService;

	// Fetch Role by Name
	public Optional<Role> getRoleByName(String roleName) {
		return roleService.findByName(roleName);
	}

	// Create or update Role
	public Role saveOrUpdateRole(Role role) {
		return roleService.save(role);
	}
}
