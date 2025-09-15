package com.lld.elevator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Queue;

@Getter
@Setter
public class RequestQueue
{
	Queue<Request> queue;
}
