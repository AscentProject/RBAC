package com.ascent_project.RBAC.Service;

import com.ascent_project.RBAC.Model.Permission;
import com.ascent_project.RBAC.Model.UserRole;
import com.ascent_project.RBAC.repository.PermissionRepository;
import com.ascent_project.RBAC.repository.RoleRepository;
import com.ascent_project.RBAC.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
private PermissionRepository repository;
    @Autowired
    private UserRoleRepository repository2;
    public Permission getById(long id){
       return  repository.getById(id);
    }
    public String save(Permission p){
       return String.valueOf(repository.save(p).getId());
    }
    public String save(UserRole p){
        return String.valueOf(repository2.save(p).getId());
    }
    public UserRole getUserRole(long role_id,Long user_id) {
        return repository2.findUserRoleBy(role_id,user_id);
    }
    public void deletePermission(Long id){
        repository.deleteById(id);
    }

    public void updatePermission(Permission permission) {
        repository.save(permission);
    }

    public List<Permission> getAllPermissions() {
        return repository.findAll();
    }

    public UserRole getUserRoleById(Long user_id) {
        return repository2.getById(user_id);
    }
}
