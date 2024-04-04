package com.openinfra.manutencao.OpenInfraManutencao.services;
import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openinfra.manutencao.OpenInfraManutencao.model.*;
import com.openinfra.manutencao.OpenInfraManutencao.services.exceptions.*;

@Service
public class AdministrationLoginService {
    @Autowired
    private AdministrationLoginServiceRepository repository;

    private boolean verifierLoginSena(String login, String senha){
        Collection<Administration> admins = repository.admins();
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

    public AdministrationLoginService findById(Integer id)
    {
        AdministrationLoginService obj = repository.findById(id).get();
        if(obj == null)
        {
            throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + AdministrationLoginService.class.getName());
        }
        return obj;
    }

    public Collection<AdministrationLoginService> findAll()
    {
        return repository.findAll();
    }

    public AdministrationLoginService insert(AdministrationLoginService obj)
    {
        obj.setIdAdministrationLoginService(null);;
        return repository.save(obj);
    }

    public AdministrationLoginService update(AdministrationLoginService obj)
    {
        findById(obj.getIdAdministrationLoginService());
        try
        {
            return repository.save(obj);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do AdministrationLoginService não foi(foram) preenchido(s)");
        }
    }
    public void delete(Integer id)
    {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um AdministrationLoginService");
        }
    }

}
