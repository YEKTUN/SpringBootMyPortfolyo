package com.porffolyo.MyPortfolyo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Info {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Id
    private Long id;


    @Column(name = "name")
    @NotEmpty(message = "Your name is not empty  ")
    @Size(min = 3, message = "Your name must be at least 3 characters  ")
    private String name;

    @NotEmpty(message = "Email is not empty")
    @Email(message = "Email is not valid")

    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Message is not empty")
    @Size(max = 300, message = "Message must be less than 300 characters")
    @Column(name = "message")
    private String message;


}
