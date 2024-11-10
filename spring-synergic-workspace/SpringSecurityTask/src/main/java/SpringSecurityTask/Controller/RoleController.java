package SpringSecurityTask.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringSecurityTask.BO.RoleBusiness;
import SpringSecurityTask.Entity.Role;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleBusiness roleBusiness;

	// Endpoint to fetch a role by name
	@GetMapping("/{roleName}")
	public ResponseEntity<Role> getRoleByName(@PathVariable String roleName) {
		return roleBusiness.getRoleByName(roleName).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Endpoint to create or update a role
	@PostMapping("/create")
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		Role savedRole = roleBusiness.saveOrUpdateRole(role);
		return ResponseEntity.ok(savedRole);
	}
}
