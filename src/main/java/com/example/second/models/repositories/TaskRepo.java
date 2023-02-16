package com.example.second.models.repositories;

import com.example.second.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, Long> {
    @Override
    Optional<Task> findById(Long aLong);
}
