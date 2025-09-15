package com.lld.elevator.controller;

import com.lld.elevator.model.DestinationQueue;
import com.lld.elevator.model.RequestQueue;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElevatorController
{
	DestinationQueue destinations;
	RequestQueue requests;
}
