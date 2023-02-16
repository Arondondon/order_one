package com.example.second.models.repositories;

import com.example.second.models.PersonTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonTaskRepo extends JpaRepository<PersonTask, Long> {
    @Override
    Optional<PersonTask> findById(Long aLong);
}
