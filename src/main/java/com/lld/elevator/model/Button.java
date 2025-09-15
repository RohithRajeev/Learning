package com.lld.elevator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Button extends Base
{
	ButtonType buttonType;
}
