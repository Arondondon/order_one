package com.example.second.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.dialect.PostgreSQLIntervalSecondJdbcType;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private PostgreSQLIntervalSecondJdbcType time;

    public Task() {}

    public Task(String description, PostgreSQLIntervalSecondJdbcType time) {
        this.description = description;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostgreSQLIntervalSecondJdbcType getTime() {
        return time;
    }

    public void setTime(PostgreSQLIntervalSecondJdbcType time) {
        this.time = time;
    }
}
