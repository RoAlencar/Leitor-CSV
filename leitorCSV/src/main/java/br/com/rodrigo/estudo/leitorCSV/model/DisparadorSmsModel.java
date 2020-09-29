package br.com.rodrigo.estudo.leitorCSV.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
@Table(name = "db_EnvioSMS")
public class DisparadorSmsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Pegar o nome do cliente
	@Column(length = 10)
	@Autowired
	private String nomeCliente;

	// Tecnologia principal que o funcionario exerce
	@Column(length = 13)
	@Autowired
	private String telCliente;

	// Mensagem que será enviada - Com o numero maximo de caracteres permitido em
	// um SMS
	@Column(length = 160)
	@Autowired
	private String Mensagem;

	private Integer idSms;

	private Integer idCliente;

	public void sms() {

	}

	public void sms(String nomeCliente, String telCliente, String Mensagem) {
		this.nomeCliente = nomeCliente;
		this.telCliente = telCliente;
		this.Mensagem = Mensagem;
	}

}
