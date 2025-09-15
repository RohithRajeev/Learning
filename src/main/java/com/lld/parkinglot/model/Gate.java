package com.lld.parkinglot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Gate extends Base
{
	@Enumerated(EnumType.STRING)
	GateType type;
	@OneToOne
	Operator operator;
	@Enumerated(EnumType.STRING)
	GateStatus status;
	@ManyToOne
	ParkingLot parkingLot;
	@OneToMany(mappedBy = "ticketGeneratedAtGate")
	List<Ticket> tickets;
}