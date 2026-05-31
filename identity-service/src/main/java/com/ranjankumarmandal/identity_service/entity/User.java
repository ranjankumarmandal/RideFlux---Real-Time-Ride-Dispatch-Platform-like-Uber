package com.ranjankumarmandal.identity_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private UUID id;

    private String email;

    private String phone;

    private String password;

    private String firstName;

    private String lastName;

    private Boolean enabled;

    private LocalDateTime createdAt;

}