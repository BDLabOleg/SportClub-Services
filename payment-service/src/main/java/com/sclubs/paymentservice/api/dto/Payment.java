package com.sclubs.paymentservice.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
    public final class Payment {
    private String TransId;
    private String userId;
    private long amount;
}
