package com.lld.parkinglot.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GenerateTicketDto
{
	VehicleRequestDto vehicleRequestDto;
	GateRequestDto gateRequestDto;
}
