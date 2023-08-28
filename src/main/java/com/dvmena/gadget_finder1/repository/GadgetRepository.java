package com.dvmena.gadget_finder1.repository;

import com.dvmena.gadget_finder1.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget,Long> {
    public List<Gadget> findByUserID(Long userID) ;
}
