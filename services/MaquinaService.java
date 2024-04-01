package com.openinfra.manutencao.OpenInfraManutencao.services;
import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openinfra.manutencao.OpenInfraManutencao.repositories.*;
import com.openinfra.manutencao.OpenInfraManutencao.model.*;


@Service
public class MaquinaService {
    @Autowired
    private MaquinaRepository repository;

    public Maquina findById(Integer id)
    {
        Maquina obj = repository.findById(id).get();
        if(obj == null)
        {
            throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Maquina.class.getName());
        }
        return obj;
    }

    public Collection<Maquina> findAll()
    {
        return repository.findAll();
    }

    public Maquina insert(Maquina obj)
    {
        obj.setidMaquina(null);;
        return repository.save(obj);
    }

    public Maquina update(Maquina obj)
    {
        findById(obj.getidMaquina());
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
        Collection<?> collection = repository.countUsuarios();
        return collection;
    }

}
