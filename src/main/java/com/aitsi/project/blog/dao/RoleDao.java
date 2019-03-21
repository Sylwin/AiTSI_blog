package com.aitsi.project.blog.dao;

import com.aitsi.project.blog.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
