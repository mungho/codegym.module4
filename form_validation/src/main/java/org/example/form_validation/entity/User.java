package org.example.form_validation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 5, max = 45, message = "First name must be between 5 and 45 characters")
    private String firstName;
    @Size(min = 5, max = 45, message = "Last name must be between 5 and 45 characters")
    private String lastName;

    @Min(value = 18, message = "Age more than 18")
    private int age;
    private String phoneNumber;
    private String email;
}
