package SpringSecurityTask.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSecurityTask.Entity.Role;
import SpringSecurityTask.Repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Optional<Role> findByName(String name) {
		return Optional.ofNullable(roleRepository.findByName(name));
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return role;
	}
}
