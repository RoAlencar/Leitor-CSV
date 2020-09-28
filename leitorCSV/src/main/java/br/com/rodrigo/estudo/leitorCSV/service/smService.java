package br.com.rodrigo.estudo.leitorCSV.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastsolutions.automacao.leitorCSV.model.modelSMS;
import br.com.fastsolutions.automacao.leitorCSV.repository.modelSmsRepository;
import br.com.rodrigo.estudo.leitorCSV.model.SMS;
import br.com.rodrigo.estudo.leitorCSV.repository.smsDTO;

@Service
public class smService {
	
	@Autowired
	modelSmsRepository msr;
	String line = "";

	public void salvaCsv() {
		long startTime = System.nanoTime();
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\\\Users\\\\rodrigo.xavier\\\\Desktop\\\\Teste.csv"));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				modelSMS sms = new modelSMS();

				sms.setNomeCliente(data[0]);
				sms.setTelCliente(data[1]);
				sms.setMensagem(data[2]);
				sms.setIdSms(null);
				sms.setIdCliente(null);

				String nome = sms.getMensagem().replace("xxxxxxxxxx", sms.getNomeCliente());
				sms.setMensagem(nome);

				ArrayList<modelSMS> mSms = new ArrayList<modelSMS>();
				mSms.add(sms);

				// msr.saveAll(mSms);
				for (modelSMS entity : mSms) {
					msr.saveAndFlush(entity);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		long totalTime = (endTime - startTime) / 1_000_000_000;

		System.out.println("\nProcesso CSV encerrado");
		System.out.println("Tempo total em segundos: " + totalTime + "s.\nTempo total em minutos: " + (totalTime / 60));
	}

}