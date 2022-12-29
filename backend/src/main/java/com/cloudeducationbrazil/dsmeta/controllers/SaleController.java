package com.cloudeducationbrazil.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudeducationbrazil.dsmeta.entities.Sale;
import com.cloudeducationbrazil.dsmeta.services.SaleService;
import com.cloudeducationbrazil.dsmeta.services.SmsService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	@Autowired
	private SaleService service;

	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public List<Sale> findAllSale(){
		return service.findAllSale();
	}

	@GetMapping(value="/periodo")
	public Page<Sale> findSalePeriodo(@RequestParam(value="dtiSale", defaultValue="") String dtiSale, 
									  @RequestParam(value="dtfSale", defaultValue="") String dtfSale, 
									  Pageable pageable){
		return service.findSalePeriodo(dtiSale, dtfSale, pageable);
	}
	
	@GetMapping(value="/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}