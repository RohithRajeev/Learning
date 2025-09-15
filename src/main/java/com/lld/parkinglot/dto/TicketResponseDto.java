package com.lld.parkinglot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class TicketResponseDto
{
	int ticketId;
	String vehicleNumber;
	VehicleType vehicleType;
	String parkingSlotNumber;
}
