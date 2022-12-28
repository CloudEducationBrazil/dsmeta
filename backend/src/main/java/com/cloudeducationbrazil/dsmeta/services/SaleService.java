package com.cloudeducationbrazil.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cloudeducationbrazil.dsmeta.entities.Sale;
import com.cloudeducationbrazil.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findAllSale(){
		return repository.findAll();
	}
	
	public Page<Sale> findSalePeriodo(String dtiDate, String dtfDate, Pageable pageable){
		LocalDate minDate = dtiDate.equals("") ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()).minusDays(365) : LocalDate.parse(dtiDate);
		LocalDate maxDate = dtfDate.equals("") ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) : LocalDate.parse(dtfDate);
		
		return repository.findSalePeriodo(minDate, maxDate, pageable);
	}
}