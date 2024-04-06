package com.openinfra.manutencao.OpenInfraManutencao.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import com.openinfra.manutencao.OpenInfraManutencao.model.Administration;
import java.util.Collection;


@Repository
public interface AdministrationRepository extends JpaRepository<Administration, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM ADMINISTRATUION" , nativeQuery = true)
    public Collection<?> admins();
}
