package br.com.rodrigo.estudo.leitorCSV.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.estudo.leitorCSV.model.SMS;

@Repository
public interface smsDTO extends CrudRepository<SMS, Integer>{

}
