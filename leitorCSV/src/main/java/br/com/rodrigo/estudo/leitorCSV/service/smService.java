package br.com.rodrigo.estudo.leitorCSV.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigo.estudo.leitorCSV.model.SMS;
import br.com.rodrigo.estudo.leitorCSV.repository.smsDTO;

@Service
public class smService {

	@Autowired
	private smsDTO sdto;

	String line = "";

	public void salvaCsv() {
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\\\Users\\\\Rodrigo de Alencar\\\\Desktop\\\\Teste.csv"));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				SMS sms = new SMS();

				sms.setNomeCliente(data[0]);
				sms.setTelCliente(data[1]);
				sms.setMensagem(data[2]);

				sdto.save(sms);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
