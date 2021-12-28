package com.sclubs.paymentservice.service;

import com.sclubs.paymentservice.repo.PaymentRepo;
import com.sclubs.paymentservice.repo.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class PaymentService {

    private final PaymentRepo paymentRepo;

    public List<Payment> fetchAll() {
        return paymentRepo.findAll();
    }

    public Payment fetchById (long id) throws IllegalArgumentException {
        final Optional<Payment> maybePayment  = paymentRepo.findById(id);
        if (maybePayment.isEmpty()) throw new IllegalArgumentException("Payment not found");
        else return maybePayment.get();
    }

    public long create (String TransId, String userId, long amount) {
        final Payment payment = new Payment(TransId, userId, amount);
        final Payment savedPayment = paymentRepo.save(payment);
        return savedPayment.getId();
    }

    public void update(long id, String TransId, String userId, long amount) throws IllegalArgumentException {
        final Optional<Payment> maybePayment = paymentRepo.findById(id);
        if (maybePayment.isEmpty()) throw new IllegalArgumentException("Payment not found");

        final Payment payment = maybePayment.get();
        if (TransId !=null && !TransId.isBlank()) payment.setTransId(TransId);
        if (userId !=null && !userId.isBlank()) payment.setuserId(userId);
        if (amount !=0 )  payment.setAmount(amount);
        paymentRepo.save(payment);

    }

    public void delete(long id) {
        paymentRepo.deleteById(id);
    }

}

