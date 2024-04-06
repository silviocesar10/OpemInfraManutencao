package com.openinfra.manutencao.OpenInfraManutencao.services;
import java.util.Collection;

import com.openinfra.manutencao.OpenInfraManutencao.repositories.AdministrationRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.openinfra.manutencao.OpenInfraManutencao.model.Administration;
import com.openinfra.manutencao.OpenInfraManutencao.services.exceptions.*;

import javax.validation.Valid;

@Service
public class AdministrationService {
    @Autowired
    private AdministrationRepository repository;

    private boolean verifierLoginSena(String login, String senha){
        Collection<Administration> admins = (Collection<Administration>) repository.admins();
        for (Administration admin : admins) {
            if (admin.getLogin().equals(login) && admin.getSenha().equals(senha)) {
                // Verifica se o login e senha batem
                return true;
            }
        }
        return false;
    }
    public boolean login(Integer id,String login, String senha) {
        return findById(id) != null && verifierLoginSena(login, senha); //login no sistema autorizado
        // Se não encontrou um admin com essas credenciais, o login falha
    }

    public Administration findById(Integer id)
    {
       Administration obj = repository.findById(id).get();
        if(obj == null)
        {
            throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Administration.class.getName());
        }
        return obj;
    }

    public Collection<Administration> findAll()
    {
        return repository.findAll();
    }

    public Administration insert(Administration obj)
    {
        obj.setIdAdministrator(null);
        return repository.save(obj);
    }

    public Administration update(Administration obj)
    {
        findById(obj.getIdAdministrator());
        try
        {
            return repository.save(obj);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Usuario não foi(foram) preenchido(s)");
        }
    }
    public void delete(Integer id)
    {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Usuario");
        }
    }
}
