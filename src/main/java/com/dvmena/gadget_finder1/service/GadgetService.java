package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.model.Gadget;
import com.dvmena.gadget_finder1.model.Response;
import com.dvmena.gadget_finder1.repository.GadgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//CRUD service function to get and save gadgets
// Add(save new gadget),get (one gadget),get all, delete (by id) update (by id)

@Transactional
@Service
@RequiredArgsConstructor
public class GadgetService {
    private final GadgetRepository gadgetRepository;

    public Response add(Gadget gadget){
        gadgetRepository.save(gadget);
        return Response.builder()
                .response(gadget.getGadget() + " has been saved")
                .build();
    }

    public Gadget update(Gadget gadget){
        return gadgetRepository.save(gadget);
    }
    public Gadget get(Long gadgetId){
        Optional<Gadget> gadget = gadgetRepository.findById(gadgetId);
        if(gadget.isPresent()){
            return gadget.get();
        }
        return null;
    }


    public void delete(Long gadgetId) {
        Optional<Gadget> gadget = gadgetRepository.findById(gadgetId);
        if(gadget.isPresent()) {
            gadgetRepository.deleteById(gadgetId);
        }
    }
    public List<Gadget> getAll(Long userID){
        return gadgetRepository.findByUserID(userID);
    }
}
