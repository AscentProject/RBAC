package com.ascent_project.RBAC.repository;

import com.ascent_project.RBAC.Model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
//Not used
public interface RoleRepository extends JpaRepository<UserRole,Long> {
}
