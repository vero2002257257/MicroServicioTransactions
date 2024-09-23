package com.example.E_mazon.application.dto.request;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String token;
}
