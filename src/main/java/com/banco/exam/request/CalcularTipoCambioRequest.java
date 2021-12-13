package com.banco.exam.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalcularTipoCambioRequest {
	
	@NotNull(message = "Monto debe ser diferente de nulo")
	private Double monto;
	@NotNull(message = "MonedaOrigen debe ser diferente de nulo")
	private String monedaOrigen;
	@NotNull(message = "MoneDestino debe ser diferente de nulo")
	private String monedaDestino;
	
	

}
