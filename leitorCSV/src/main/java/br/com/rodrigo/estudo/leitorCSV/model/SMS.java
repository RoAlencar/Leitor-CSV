package br.com.rodrigo.estudo.leitorCSV.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "db_EnvioSMS")
public class SMS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Pegar o nome do cliente
	@Column(length = 10)
	private String nomeCliente;

	// Tecnologia principal que o funcionario exerce
	@Column(length = 13)
	private String telCliente;

	// Mensagem que será enviada - Com o numero maximo de caracteres permitido em um SMS
	@Column(length = 160)
	private String Mensagem;

	
}
