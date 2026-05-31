package com.ranjankumarmandal.identity_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
public class ValidateTokenResponse {

    private UUID userId;

    private String email;

    private String role;

    private Boolean valid;

}