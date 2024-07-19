package com.example.demo.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleModel> getRoles(){
        return roleService.getRoles();
    }

    @PutMapping
    public void registerNewRole(@RequestBody RoleModel role){
        roleService.addNewRole(role);
    }

    @DeleteMapping(path = "{roleId}")
    public void deleteRole(@PathVariable("roleId") Long roleId){
        roleService.deleteRole(roleId);
    }

    @PutMapping(path = "{roleId}")
    public void updateRole(@PathVariable("roleId") Long roleId,
                           @RequestParam(required = false) String name){
        roleService.updateRole(roleId, name);
    }
}
