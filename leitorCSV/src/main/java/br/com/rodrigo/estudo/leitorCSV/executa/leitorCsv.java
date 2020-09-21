package br.com.rodrigo.estudo.leitorCSV.executa;

import java.io.File;
import java.util.Scanner;

import br.com.rodrigo.estudo.leitorCSV.model.SMS;

public class leitorCsv {

	public static void main(String[] args) {

		File arquivoCSV = new File("C:\\Users\\Rodrigo de Alencar\\Desktop\\Teste.csv");

		try {
			String linhasDoArquivo = new String();
			@SuppressWarnings("resource")
			Scanner leitor = new Scanner(arquivoCSV);
			leitor.nextLine();

			while (leitor.hasNext()) {

				linhasDoArquivo = leitor.nextLine();
				String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
				SMS model = new SMS();
				model.setNomeCliente(valoresEntreVirgulas[0]);
				model.setTelCliente(valoresEntreVirgulas[1]);
				model.setMensagem(valoresEntreVirgulas[2]);
				
				String rpl = model.getMensagem();
				rpl.replace("xxxxxxxxxx", model.getNomeCliente());
				System.out.println(model.getNomeCliente());
				System.out.println(model.getTelCliente());
				System.out.println(model.getMensagem());
					

				//System.out.println(valoresEntreVirgulas[0] + " " + valoresEntreVirgulas[1]);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		{

		}
	}
}
