package com.lld.parkinglot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Operator extends Base
{
	String operatorName;
	@OneToOne
	Gate gate;
}
