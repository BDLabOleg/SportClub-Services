package com.sclubs.authservice.service;

import com.sclubs.authservice.repo.AuthRepo;
import com.sclubs.authservice.repo.model.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class AuthService {

   private final AuthRepo authRepo;

   public List<Auth> fetchAll() {
      return authRepo.findAll();
   }

   public Auth fetchById (long id) throws IllegalArgumentException {
      final Optional<Auth> maybeAuth  = authRepo.findById(id);
      if (maybeAuth.isEmpty()) throw new IllegalArgumentException("Auth not found");
      else return maybeAuth.get();
   }

   public long create (String email, String password, long code) {
      final Auth auth = new Auth(email, password, code);
      final Auth savedAuth = authRepo.save(auth);
      return savedAuth.getId();
   }

   public void update(long id, String email, String password, long code) throws IllegalArgumentException {
      final Optional<Auth> maybeAuth = authRepo.findById(id);
      if (maybeAuth.isEmpty()) throw new IllegalArgumentException("Auth not found");

      final Auth auth = maybeAuth.get();
      if (email !=null && !email.isBlank()) auth.setEmail(email);
      if (password !=null && !password.isBlank()) auth.setPassword(password);
      if (code !=0 )  auth.setCode(code);
      authRepo.save(auth);

   }

   public void delete(long id) {
      authRepo.deleteById(id);
   }

}
