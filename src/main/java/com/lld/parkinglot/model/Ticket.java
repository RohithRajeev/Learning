package com.lld.parkinglot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends Base
{
	@ManyToOne
	Vehicle vehicle;
	Date entryTime;
	Date exitTime;
	@ManyToOne
	Gate ticketGeneratedAtGate;
	@ManyToOne
	ParkingSlot parkingSlot;
}
