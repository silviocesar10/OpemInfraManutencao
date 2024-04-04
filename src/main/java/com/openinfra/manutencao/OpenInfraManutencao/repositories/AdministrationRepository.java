package com.openinfra.manutencao.OpenInfraManutencao.repositories;

import com.openinfra.administration.OpenInfraAdministration.model.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openinfra.administration.OpenInfraAdministration.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Repository
public interface AdministrationRepository extends JpaRepository<Administration, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM ADMINISTRATUION" , nativeQuery = true)
    public Collection<?> admins();
}
