package com.workshop.dabat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
}
