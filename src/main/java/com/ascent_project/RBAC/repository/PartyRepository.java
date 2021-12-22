package com.ascent_project.RBAC.repository;

import com.ascent_project.RBAC.Model.IndividualParty;
import org.springframework.data.jpa.repository.JpaRepository;
//not used
public interface PartyRepository extends JpaRepository<IndividualParty,Long> {
}
