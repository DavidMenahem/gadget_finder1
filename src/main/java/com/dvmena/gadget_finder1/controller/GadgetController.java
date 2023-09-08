package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.Gadget;
import com.dvmena.gadget_finder1.model.Response;
import com.dvmena.gadget_finder1.service.GadgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gadget/")
@RequiredArgsConstructor
public class GadgetController {
    private final GadgetService gadgetService;

    @PostMapping("/add")
    public Response add(@RequestBody Gadget gadget){
        return gadgetService.add(gadget);
    }

    @PutMapping Gadget update(@RequestBody Gadget gadget){
        return gadgetService.update(gadget);
    }

    @GetMapping("/{gadgetId}")
    public Gadget get(@PathVariable Long gadgetId){
        return gadgetService.get(gadgetId);
    }

    @GetMapping("/all/{userID}")
    public List<Gadget> getALl(@PathVariable Long userID){
        return gadgetService.getAll(userID);
    }

    @DeleteMapping("/{gadgetId}")
    public void delete(@PathVariable Long gadgetId){
        gadgetService.delete(gadgetId);
    }
}
