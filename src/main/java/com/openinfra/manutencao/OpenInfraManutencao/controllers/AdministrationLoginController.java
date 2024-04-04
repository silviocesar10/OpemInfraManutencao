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
import com.openinfra.manutencao.OpenInfraManutencao.services.exceptions.*;

@RestController
@RequestMapping(value = "/administration")
public class AdministrationLoginController {
    @Autowired
    private AdministrationLoginService service;

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ResponseEntity<AdministrationLogin> login(@PathVariable Integer id, @PathVariable String login, @PathVariable String senha) {
        AdministrationLogin obj = service;
        if(service.login(id, login, senha)){
            return ResponseEntity.ok().body(String.parse("Logado com sucesso!!"));
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<AdministrationLogin>> findAll() {
        Collection<AdministrationLogin> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AdministrationLogin> find(@PathVariable Integer id) {
        AdministrationLogin obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@Valid @RequestBody AdministrationLogin obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AdministrationLogin> update(@Valid @RequestBody AdministrationLogin obj, BindingResult br) {
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

