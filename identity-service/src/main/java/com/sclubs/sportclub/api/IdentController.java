package com.sclubs.sportclub.api;

import com.sclubs.sportclub.repo.model.Ident;
import com.sclubs.sportclub.service.IdentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public final class IdentController {

    private final IdentService identService;

    @GetMapping
    public ResponseEntity<List<com.sclubs.sportclub.repo.model.Ident>> index() {
        final List<com.sclubs.sportclub.repo.model.Ident> idents = identService.fetchall();
        return ResponseEntity.ok(idents);
    }

    @GetMapping("/{id}")
    public ResponseEntity <com.sclubs.sportclub.repo.model.Ident> show(@PathVariable long id) {
        try {
            final com.sclubs.sportclub.repo.model.Ident ident = identService.fetchById(id);
            return ResponseEntity.ok(ident);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.sclubs.sportclub.api.dto.Ident ident) {
        final String userId = ident.getUserId();
        final String password = ident.getPassword();
        final String email = ident.getEmail();
        final long id = identService.create(userId, password, email);
        final String location = String.format("/users/%d", id);
        return ResponseEntity.created(URI.create(location)).build();
        }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.sclubs.sportclub.api.dto.Ident ident) {
        final String userId = ident.getUserId();
        final String password = ident.getPassword();
        final String email = ident.getEmail();

        try {
            identService.update(id, userId, password, email);

            return ResponseEntity.noContent().build();
        }  catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id)  {
          identService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
