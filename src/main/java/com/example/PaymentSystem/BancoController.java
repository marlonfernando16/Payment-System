package com.example.PaymentSystem;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BancoController {

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String pay(@RequestBody String cadastro_banco) throws Exception {
	new BancoProducerService().createQueue(cadastro_banco);
	
	return cadastro_banco;	

	}
}
