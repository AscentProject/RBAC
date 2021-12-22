package com.ascent_project.RBAC.Controller;

import com.ascent_project.RBAC.Model.Permission;
import com.ascent_project.RBAC.Model.UserRole;
import com.ascent_project.RBAC.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRoleController {
    @Autowired
    PermissionService service;

    @GetMapping("/userRole/{user_id}")
    public ResponseEntity<?> getData(@PathVariable (name="user_id") Long user_id){
        ResponseEntity<String> resp = null;
        try{
//            String id = service.save(permission);
            UserRole p=service.getUserRoleById(user_id);
            resp= new ResponseEntity<String>(String.valueOf(p), HttpStatus.CREATED); //201-created
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>("Unable to get Permission", HttpStatus.INTERNAL_SERVER_ERROR); //500-Internal Server Error
        }
        return resp;
    }
    @PostMapping("/userRole")
    public ResponseEntity<String> saveData(@RequestBody UserRole ur){

        ResponseEntity<String> resp = null;
        try{
//            UserRole userRole=service.getUserRole(role_id,user_id);
//            permission.setUserRole(userRole);
            String id = service.save(ur);
            resp= new ResponseEntity<String>(
                    "Permission '"+id+"' created", HttpStatus.CREATED); //201-created
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to save Permission",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500-Internal Server Error
        }
        return resp;
    }
}
