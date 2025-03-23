package com.cog.dao;

import com.cog.dom.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Additional queries (if needed) can be added here
}
