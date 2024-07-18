package com.example.demo.Role;

import com.example.demo.User.UserModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<RoleModel> getRoles(){
        return roleRepository.findAll();
    }

    public void addNewRole(RoleModel role){
        Optional<RoleModel> roleOptional = roleRepository.findById(role.getId());
        if(roleOptional.isPresent()){
            throw new IllegalStateException("Role already in use");
        }
        roleRepository.save(role);
    }

    public void deleteRole(Long roleId){
        boolean exists = roleRepository.existsById(roleId);
        if (!exists){
            throw new IllegalStateException("Role with id " + roleId + " does not exist");
        }
        roleRepository.deleteById(roleId);
    }

    @Transactional
    public void updateRole(Long roleId, String name){
        RoleModel role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + roleId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(role.getName(), name)){
            Optional<RoleModel> roleOptional = roleRepository.findByName(name);
            if (roleOptional.isPresent()){
                throw new IllegalStateException("Username taken");
            }
            role.setName(name);
        }
    }

}
