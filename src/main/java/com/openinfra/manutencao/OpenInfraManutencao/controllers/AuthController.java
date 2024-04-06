package com.openinfra.manutencao.OpenInfraManutencao.controllers;

import java.util.Collection;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.openinfra.manutencao.OpenInfraManutencao.services.*;
import com.openinfra.manutencao.OpenInfraManutencao.services.AdministrationService;
import com.openinfra.manutencao.OpenInfraManutencao.services.exceptions.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private AdministrationService service;

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ResponseEntity<Object> login(@PathVariable Integer id, @PathVariable String login, @PathVariable String senha) {
        if (service.login(id, login, senha)) {
            return ResponseEntity.ok().body("Logado com sucesso!!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}