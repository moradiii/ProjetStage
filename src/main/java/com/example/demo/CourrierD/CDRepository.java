package com.example.demo.CourrierD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CDRepository extends JpaRepository<CDModel, Long> {

    @Query("SELECT u FROM CDModel u WHERE u.type = :type")
    Optional<CDModel> findByType(String type);

    @Query("SELECT u FROM CDModel u WHERE u.num = :num")
    Optional<CDModel> findeByNumber(Long num);
}
