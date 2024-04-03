package com.openinfra.manutencao.OpenInfraManutencao.services;
import java.util.Collection;

import com.openinfra.manutencao.OpenInfraManutencao.model.Manutencao;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openinfra.manutencao.OpenInfraManutencao.repositories.*;
import com.openinfra.manutencao.OpenInfraManutencao.model.Manutencao;
import com.openinfra.manutencao.OpenInfraManutencao.services.exceptions.ObjectNotFoundException;
import com.openinfra.manutencao.OpenInfraManutencao.services.exceptions.DataIntegrityException;
@Service
public class ManutencaoService {
    @Autowired
    private ManutencaoRepository repository;

    public Manutencao findById(Integer id)
    {
        Manutencao obj = repository.findById(id).get();
        if(obj == null)
        {
            throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Manutencao.class.getName());
        }
        return obj;
    }

    public Collection<Manutencao> findAll()
    {
        return repository.findAll();
    }

    public Manutencao insert(Manutencao obj)
    {
        obj.setIdManutencao(null);
        return repository.save(obj);
    }

    public Manutencao update(Manutencao obj)
    {
        findById(obj.getIdManutencao());
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
    public Collection<?> countManutencoes() {
        Collection<?> collection = repository.countManutencao();
        return collection;
    }

}
