package com.cloudeducationbrazil.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cloudeducationbrazil.dsmeta.entities.Sale;
import com.cloudeducationbrazil.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository repository;

	public void sendSms(Long saleId) {

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		
		Sale sale = repository.findById(saleId).get();
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		
		String corpoMessage = "Id: " + saleId.toString() + " - vendedor: " + sale.getSellerName() + 
				              ", foi destaque no mês " + date.toString() + ", com um total de R$" + String.format("%.2f", sale.getAmount()) + ".";
		
		// String corpoMessage = "Id" + saleId.toString() + " - o vendedor: " + sale.getSellerName() + 
        //                       " foi destaque no mês " + date.toString() + " com um total de R$" + 
		// new DecimalFormat("#,###.00").format(sale.getAmount());
		
		// String corpoMessage = String.format("Id %s - o vendedor: %s foi destaque no mês %s com um total de R$ %.2f", 
		// saleId.toString(), sale.getSellerName(), date.toString(), sale.getAmount());
		

		Message message = Message.creator(to, from, corpoMessage).create();

		System.out.println(message.getSid());
	}
}