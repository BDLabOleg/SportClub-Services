package com.sclubs.sportclub.repo;

import com.sclubs.sportclub.repo.model.Ident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentRepo extends JpaRepository<Ident, Long>  {
}
