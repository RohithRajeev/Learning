package com.lld.parkinglot.service;

import com.lld.parkinglot.model.Gate;
import com.lld.parkinglot.repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GateService
{
	GateRepository gateRepository;

	public GateService(GateRepository gateRepository)
	{
		this.gateRepository = gateRepository;
	}

	public Optional<Gate> getGateById(int gateId)
	{
		return Optional.of(gateRepository.getReferenceById(gateId));
	}
}
