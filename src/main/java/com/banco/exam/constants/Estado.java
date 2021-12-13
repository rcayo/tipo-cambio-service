package com.banco.exam.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Estado {
	
	ACTIVE(true), INACTIVE(false);
	   private Boolean value;

}
