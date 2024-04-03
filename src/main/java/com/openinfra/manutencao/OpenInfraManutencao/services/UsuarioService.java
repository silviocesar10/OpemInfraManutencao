package com.openinfra.manutencao.OpenInfraManutencao.services;
import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openinfra.manutencao.OpenInfraManutencao.repositories.*;
import com.openinfra.manutencao.OpenInfraManutencao.model.*;
import com.openinfra.manutencao.OpenInfraManutencao.services.exceptions.*;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Integer id)
    {
        Usuario obj = repository.findById(id).get();
        if(obj == null)
        {
            throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Usuario.class.getName());
        }
        return obj;
    }

    public Collection<Usuario> findAll()
    {
        return repository.findAll();
    }

    public Usuario insert(Usuario obj)
    {
        obj.setIdUsuario(null);;
        return repository.save(obj);
    }

    public Usuario update(Usuario obj)
    {
        findById(obj.getIdUsuario());
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
    public Collection<?> countUsuarios() {
        Collection<?> collection = repository.countUsuario();
        return collection;
    }

}
