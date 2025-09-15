package com.lld.parkinglot.repository;

import com.lld.parkinglot.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Integer>
{
}
