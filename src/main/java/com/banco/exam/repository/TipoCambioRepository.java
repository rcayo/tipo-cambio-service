package com.banco.exam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.banco.exam.entity.TipoCambioEntity;

public interface TipoCambioRepository extends CrudRepository<TipoCambioEntity, Long>{
	
	@Query("SELECT t FROM TipoCambioEntity t "
			+ " WHERE t.tipoMonedaOrigen = :monedaOrigen AND " 
			+ " t.tipoMonedaDestino =:monedaDestino AND t.isActive = :isActive")
	Optional<TipoCambioEntity> buscarPorMonedaOrigenYDestino(String monedaOrigen
			, String monedaDestino, Boolean isActive);
}
