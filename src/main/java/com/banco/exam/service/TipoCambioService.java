package com.banco.exam.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.exam.constants.Estado;
import com.banco.exam.entity.TipoCambioEntity;
import com.banco.exam.exception.ResourceNotFoundException;
import com.banco.exam.repository.TipoCambioRepository;
import com.banco.exam.request.ActualizarTipoCambioRequest;
import com.banco.exam.request.CalcularTipoCambioRequest;
import com.banco.exam.response.ActualizarTipoCambioResponse;
import com.banco.exam.response.CalcularTipoCambioResponse;

import lombok.AllArgsConstructor;
import rx.Observable;
import rx.Single;

@Service
@AllArgsConstructor
public class TipoCambioService {
	
	TipoCambioRepository tipoCambioRepository;
	
	public CalcularTipoCambioResponse calcular(CalcularTipoCambioRequest request) {
		TipoCambioEntity entity = tipoCambioRepository.buscarPorMonedaOrigenYDestino
					(request.getMonedaOrigen().toUpperCase(), request.getMonedaDestino().toUpperCase(),
							Estado.ACTIVE.getValue())
					.orElseThrow(() ->new ResourceNotFoundException("Tipo de cambio no encontrado"));
		
		double montoConTipoCambio = request.getMonto() * entity.getValor();
		System.out.println("VALOR =>"+ entity.getValor());
		
		CalcularTipoCambioResponse response = CalcularTipoCambioResponse.builder()
				.monto(request.getMonto())
				.montoConTipoCambio(montoConTipoCambio)
				.monedaOrigen(entity.getTipoMonedaOrigen())
				.monedaDestino(entity.getTipoMonedaDestino())
				.tipoDeCambio(entity.getValor())
				.build();
		
		return response;
	}
	
	@Transactional(readOnly = false)
	public ActualizarTipoCambioResponse actualizar(ActualizarTipoCambioRequest request) {
		
		TipoCambioEntity entity = tipoCambioRepository.buscarPorMonedaOrigenYDestino
				(request.getMonedaOrigen().toUpperCase(), request.getMonedaDestino().toUpperCase(),
						Estado.ACTIVE.getValue())
				.orElseThrow(() ->new ResourceNotFoundException("Tipo de cambio no encontrado"));
			
		entity.setValor(request.getNuevoTipoCambio());
		
		Single<TipoCambioEntity> single = Observable.just(entity)
		.toSingle()
		.doOnSuccess(e -> tipoCambioRepository.save(e))
		.doOnError(error -> {
		      throw new RuntimeException(error.getMessage());
		  });
		single.subscribe();
		
		
		ActualizarTipoCambioResponse response = ActualizarTipoCambioResponse.builder()
				.monedaOrigen(entity.getTipoMonedaOrigen().toUpperCase())
				.monedaDestino(entity.getTipoMonedaDestino().toUpperCase())
				.nuevoValor(entity.getValor())
				.build();
		return response;
	}
	

}
