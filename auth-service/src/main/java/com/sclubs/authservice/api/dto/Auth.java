package com.sclubs.authservice.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Auth {
    private String email;
    private String password;
    private long code;

}
