package com.ascent_project.RBAC.Controller;

import com.ascent_project.RBAC.Model.Permission;
import com.ascent_project.RBAC.Model.UserRole;
import com.ascent_project.RBAC.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/role")
public class PermissionController {
    @Autowired
    private PermissionService service;
    @PostMapping("/{role_id}/user/{user_id}/permission")
    public ResponseEntity<String> saveData(@PathVariable (name="role_id") Long role_id,@PathVariable (name="user_id") Long user_id,@RequestBody Permission permission){

        ResponseEntity<String> resp = null;
        try{
            UserRole userRole=service.getUserRole(role_id,user_id);
            permission.setUserRole(userRole);
            String id = service.save(permission);
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
    @GetMapping("/{role_id}/user/{user_id}/permission/{permission_id}")
    public ResponseEntity<?> getData(@PathVariable (name="role_id") Long role_id,@PathVariable (name="user_id") Long user_id,@PathVariable(name="permission_id") Long permission_id){
        ResponseEntity<String> resp = null;
        try{
//            String id = service.save(permission);
            Permission p=service.getById(permission_id);
            resp= new ResponseEntity<String>(String.valueOf(p), HttpStatus.CREATED); //201-created
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>("Unable to get Permission", HttpStatus.INTERNAL_SERVER_ERROR); //500-Internal Server Error
        }
        return resp;
    }
    @DeleteMapping("/{role_id}/user/{user_id}/permission/{permission_id}")
    public ResponseEntity<?> deleteData(@PathVariable (name="role_id") Long role_id,@PathVariable (name="user_id") Long user_id,@PathVariable(name="permission_id") Long permission_id){
        ResponseEntity<String> resp= null;
        try {
            service.deletePermission(permission_id);
            resp= new ResponseEntity<String> (
                    "Invoice '"+permission_id+"' deleted",HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "Unable to delete Invoice", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }
    @PutMapping("/{role_id}/user/{user_id}/permission")
    public ResponseEntity<String> updateInvoice(@PathVariable(name="role_id") Long role_id,@PathVariable(name="user_id") Long user_id, @RequestBody Permission permission){

        ResponseEntity<String> resp = null;
        try {
            Permission per= service.getById(permission.getId());

            service.updatePermission(per);
            resp = new ResponseEntity<String>(
                    "Permission '"+per.getId()+"'id is Updated",
                    HttpStatus.RESET_CONTENT); //205- Reset-Content(PUT)
        }
         catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to Update permission",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500-ISE
        }
        return resp;
    }
    @GetMapping("/{role_id}/user/{user_id}/permission")
    public ResponseEntity<?> getAllData(@PathVariable (name="role_id") Long role_id,@PathVariable (name="user_id") Long user_id){
        ResponseEntity<String> resp = null;
        try{
//            String id = service.save(permission);
            List<Permission> p=service.getAllPermissions();
            resp= new ResponseEntity<String>(String.valueOf(p), HttpStatus.CREATED); //201-created
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>("Unable to get Permission", HttpStatus.INTERNAL_SERVER_ERROR); //500-Internal Server Error
        }
        return resp;
    }
}
