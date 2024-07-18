package com.example.demo.Role;

import com.example.demo.Role.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    @Query("SELECT u FROM RoleModel u WHERE u.name = :name")
    Optional<RoleModel> findByName(String name);
}
