package com.lld.parkinglot.repository;

import com.lld.parkinglot.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer>
{
}
