package com.example.demo.CourrierA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CARepository extends JpaRepository<CAModel, Long> {

    @Query("SELECT u FROM CAModel u WHERE u.type = :type")
    Optional<CAModel> findByType(String type);

    @Query("SELECT u FROM CAModel u WHERE u.num = :num")
    Optional<CAModel> findeByNumber(long num);
}
