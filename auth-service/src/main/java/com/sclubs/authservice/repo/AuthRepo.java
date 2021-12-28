package com.sclubs.authservice.repo;

import com.sclubs.authservice.repo.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<Auth, Long> {

}
