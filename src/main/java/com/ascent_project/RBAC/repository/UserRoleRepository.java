package com.ascent_project.RBAC.repository;

import com.ascent_project.RBAC.Model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//@EnableJpaRepositories
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    @Modifying
    @Query(value="SELECT u FROM user_role u WHERE u.role_id = :role_id and u.user_id = :user_id",nativeQuery = true)
    UserRole findUserRoleBy(Long role_id, Long user_id);
}
