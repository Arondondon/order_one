package com.example.second.models.repositories;

import com.example.second.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {
    @Override
    Optional<Person> findById(Long aLong);
}
