package com.cloudeducationbrazil.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
