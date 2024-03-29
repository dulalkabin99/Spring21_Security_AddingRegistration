package com.dulal.spring_security_21;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {

    Role findByRole(String role);
}
