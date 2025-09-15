package com.lld.elevator.model;

import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.Destination;
import java.util.PriorityQueue;

@Getter
@Setter
public class DestinationQueue
{
	PriorityQueue<Destination> destinations;
}
