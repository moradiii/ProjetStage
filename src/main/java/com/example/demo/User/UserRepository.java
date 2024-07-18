package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT u FROM UserModel u WHERE u.username = :username")
    Optional<UserModel> findByUsername(String username);

    @Query("SELECT u FROM UserModel u WHERE u.email = :email")
    Optional<UserModel> findByEmail(String email);

    UserModel findByEmailAndPwd(String email, String pwd);
}
