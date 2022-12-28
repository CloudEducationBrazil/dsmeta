package com.cloudeducationbrazil.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudeducationbrazil.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("select obj from Sale obj where obj.date between :minDate and :maxDate order by obj.amount desc")
	Page<Sale> findSalePeriodo(LocalDate minDate, LocalDate maxDate, Pageable pageable);
}