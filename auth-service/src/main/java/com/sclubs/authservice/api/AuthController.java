package com.sclubs.authservice.api;

import com.sclubs.authservice.repo.model.Auth;
import com.sclubs.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/users")

public final class AuthController {

    private final AuthService authService;

         @GetMapping
         public ResponseEntity<List<com.sclubs.authservice.repo.model.Auth>> index() {
             final List<com.sclubs.authservice.repo.model.Auth> auths = authService.fetchAll();
             return ResponseEntity.ok(auths);
        }

        @GetMapping("/{id}")
        public ResponseEntity<com.sclubs.authservice.repo.model.Auth> show(@PathVariable long id) {
             try {
                 final com.sclubs.authservice.repo.model.Auth auth = authService.fetchById(id);
                 return ResponseEntity.ok(auth);
             } catch (IllegalArgumentException e) {
               return ResponseEntity.notFound().build();
               }
        }

        @PostMapping
        public ResponseEntity<Void> create(@RequestBody com.sclubs.authservice.api.dto.Auth auth ) {
             final String email = auth.getEmail();
             final String password = auth.getPassword();
             final long code = auth.getCode();
             final long id = authService.create (email, password, code);
             final String location = String.format("/users/%d", id);
             return ResponseEntity.created(URI.create(location)).build();
        }

        @PatchMapping("/{id}")
        public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.sclubs.authservice.repo.model.Auth auth ) {
            final String email = auth.getEmail();
            final String password = auth.getPassword();
            final long code = auth.getCode();


            try {
                authService.update(id, email, password, code);

            //    final com.sclubs.authservice.repo.model.Auth auth = authService.fetchById(id)
                return ResponseEntity.noContent().build();
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            }

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable long id) {
            authService.delete(id);
            return ResponseEntity.noContent().build();
         }
}
