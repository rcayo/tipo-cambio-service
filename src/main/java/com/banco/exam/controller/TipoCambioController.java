package com.banco.exam.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banco.exam.request.ActualizarTipoCambioRequest;
import com.banco.exam.request.CalcularTipoCambioRequest;
import com.banco.exam.response.ActualizarTipoCambioResponse;
import com.banco.exam.response.CalcularTipoCambioResponse;
import com.banco.exam.service.TipoCambioService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.OPTIONS, RequestMethod.PATCH})
@AllArgsConstructor
public class TipoCambioController {
	
	TipoCambioService tipopcambioservice;
	@RequestMapping("/calcular")
	@PostMapping
	public ResponseEntity<CalcularTipoCambioResponse> calcular(@Valid @RequestBody CalcularTipoCambioRequest request   ){
		
		log.info("calculando : calcular request = {}", request);
		
		CalcularTipoCambioResponse response=tipopcambioservice.calcular(request);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@RequestMapping("/actualizar")
	@PostMapping
	public ResponseEntity<ActualizarTipoCambioResponse> actualizar(@Valid @RequestBody ActualizarTipoCambioRequest request){
		
		ActualizarTipoCambioResponse response= tipopcambioservice.actualizar(request);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	

}
