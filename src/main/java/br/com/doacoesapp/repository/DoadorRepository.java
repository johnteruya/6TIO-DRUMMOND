package br.com.doacoesapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.doacoesapp.models.Doador;

public interface DoadorRepository extends CrudRepository<Doador, String>{
	Doador findByCodigo(long codigo);
}
