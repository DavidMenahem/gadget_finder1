package com.dvmena.gadget_finder1.repository;

import com.dvmena.gadget_finder1.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Long> {
    public Optional<Register> findByEmail(String email);
}
