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
public class ActualizarTipoCambioRequest {
	@NotNull(message = "MonedaOrigen debe ser diferente de nulo")
	private String monedaOrigen;
	@NotNull(message = "MonedaDestino debe ser diferente de nulo")
	private String monedaDestino;
	@NotNull(message = "nuevoTipoCambio debe ser diferente de nulo")
	private Double nuevoTipoCambio;

}
