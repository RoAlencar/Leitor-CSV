package br.com.fastsolutions.automacao.disparadorSMS.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastsolutions.automacao.disparadorSMS.model.DisparadorSmsModel;
import br.com.fastsolutions.automacao.disparadorSMS.repository.DisparadorSmsRepository;


@Service
public class DisparadorSmsService {
	
	@Autowired
	DisparadorSmsRepository DSR;
	String line = "";

	public void salvaCsv() {
		long startTime = System.nanoTime();
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\\\Users\\\\rodrigo.xavier\\\\Desktop\\\\Teste.csv"));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				DisparadorSmsModel sms = new DisparadorSmsModel();

				sms.setNomeCliente(data[0]);
				sms.setTelCliente(data[1]);
				sms.setMensagem(data[2]);
				sms.setIdSms(null);
				sms.setIdCliente(null);

				String nome = sms.getMensagem().replace("xxxxxxxxxx", sms.getNomeCliente());
				sms.setMensagem(nome);

				ArrayList<DisparadorSmsModel> mSms = new ArrayList<DisparadorSmsModel>();
				mSms.add(sms);

				// msr.saveAll(mSms);
				for (DisparadorSmsModel entity : mSms) {
					DSR.saveAndFlush(entity);
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