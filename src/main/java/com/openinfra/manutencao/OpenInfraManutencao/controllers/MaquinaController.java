package com.openinfra.manutencao.OpenInfraManutencao.controllers;

import java.util.Collection;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.openinfra.manutencao.OpenInfraManutencao.services.*;
import com.openinfra.manutencao.OpenInfraManutencao.model.*;
import com.openinfra.manutencao.OpenInfraManutencao.services.exceptions.*;

@RestController
@RequestMapping(value = "/maquinas")
public class MaquinaController {
    @Autowired
    private MaquinaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Maquina>> findAll() {
        Collection<Maquina> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Maquina> find(@PathVariable Integer id) {
        Maquina obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Maquina> insert(@Valid @RequestBody Maquina obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Maquina> update(@Valid @RequestBody Maquina obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


