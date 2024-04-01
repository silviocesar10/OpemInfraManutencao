package com.openinfra.manutencao.OpenInfraManutencao.repositories;

import java.util.Collection;

import com.openinfra.manutencao.OpenInfraManutencao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openinfra.manutencao.OpenInfraManutencao.model.*;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(*) FROM USARIO" , nativeQuery = true)
    public Collection<?> countUsuario();
}
