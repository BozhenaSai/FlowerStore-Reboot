package ua.edu.ucu.apps.lab8.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@Table
@Entity(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}