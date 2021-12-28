package com.sclubs.paymentservice.api;

import com.sclubs.paymentservice.repo.model.Payment;
import com.sclubs.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
    public final class PaymentController {

        private final PaymentService paymentService;

        @GetMapping
        public ResponseEntity<List<com.sclubs.paymentservice.repo.model.Payment>> index() {
            final List<com.sclubs.paymentservice.repo.model.Payment> payments = paymentService.fetchAll();
            return ResponseEntity.ok(payments);
        }


        @GetMapping("/{id}")
        public ResponseEntity<com.sclubs.paymentservice.repo.model.Payment> show(@PathVariable long id) {
            try {
                final com.sclubs.paymentservice.repo.model.Payment payment = paymentService.fetchById(id);
                return ResponseEntity.ok(payment);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public ResponseEntity<Void> create(@RequestBody com.sclubs.paymentservice.api.dto.Payment payment ) {
            final String TransId = payment.getTransId();
            final String userId =payment.getUserId();
            final long amount = payment.getAmount();
            final long id = paymentService.create (TransId, userId, amount);
            final String location = String.format("/users/%d", id);
            return ResponseEntity.created(URI.create(location)).build();
        }

        @PatchMapping("/{id}")
        public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.sclubs.paymentservice.repo.model.Payment payment ) {
            final String TransId = payment.getTransId();
            final String userId = payment.getuserId();
            final long amount = payment.getAmount();


            try {
                paymentService.update(id, TransId, userId, amount);

            //    final com.sclubs.paymentservice.repo.model.Payment payment = paymentService.fetchById(id);
                return ResponseEntity.noContent().build();
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            }

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable long id) {
            paymentService.delete(id);
            return ResponseEntity.noContent().build();
        }
  }
