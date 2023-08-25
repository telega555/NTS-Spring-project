package com.example.ntsspringproject.repository;

import com.example.ntsspringproject.entity.LogInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public interface LogInformationRepository extends JpaRepository<LogInformation, Long> {
    List<LogInformation> findAll();
}
