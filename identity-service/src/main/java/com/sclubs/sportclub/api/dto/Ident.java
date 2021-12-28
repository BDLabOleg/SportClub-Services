package com.sclubs.sportclub.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Ident {
    private String userId;
    private String password;
    private String email;

}
