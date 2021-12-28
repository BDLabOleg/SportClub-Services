package com.sclubs.sportclub.service;

import com.sclubs.sportclub.repo.IdentRepo;
import com.sclubs.sportclub.repo.model.Ident;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IdentService {

    private final IdentRepo identRepo;

    public List<Ident> fetchall() {
       return identRepo.findAll();
    }

    public Ident fetchById(long id) throws IllegalArgumentException {
        final Optional<Ident> maybeIdent= identRepo.findById(id);

        if (maybeIdent.isEmpty()) throw new IllegalArgumentException("Ident not found");
        else return maybeIdent.get();
    }

    public long create(String userId, String password, String email) {
        final Ident ident = new Ident(userId, password, email);
        final Ident savedIdent = identRepo.save(ident);
        return savedIdent.getId();
    }

    public void update(long id, String userId, String password, String email) throws IllegalArgumentException{
        final Optional<Ident> maybeIdent = identRepo.findById(id);
        if (maybeIdent.isEmpty()) throw new IllegalArgumentException("Ident not found");

        final Ident ident = maybeIdent.get();
        if (userId !=null && !userId.isBlank()) ident.setUserId(userId);
        if (password !=null && !password.isBlank()) ident.setPassword(password);
        if (email !=null && !email.isBlank()) ident.setEmail(email);
        identRepo.save(ident);
    }

    public void delete(long id) {
        identRepo.deleteById(id);
     }
}
