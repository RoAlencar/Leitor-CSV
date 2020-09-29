package br.com.fastsolutions.automacao.disparadorSMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fastsolutions.automacao.disparadorSMS.service.smService;

@RestController
public class Controller {

	@Autowired
	private smService sS;
	
	@RequestMapping(path ="popularTabela")
	public void setDataInDB() {
		sS.salvaCsv();
	}
	
}
