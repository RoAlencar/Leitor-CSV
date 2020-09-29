package br.com.fastsolutions.automacao.disparadorSMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fastsolutions.automacao.disparadorSMS.model.DisparadorSmsModel;

@Repository
public interface DisparadorSmsRepository extends JpaRepository<DisparadorSmsModel, String>{

}
