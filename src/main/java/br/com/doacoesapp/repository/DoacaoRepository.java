package br.com.doacoesapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.doacoesapp.models.Doacao;
import br.com.doacoesapp.models.Doador;

public interface DoacaoRepository extends CrudRepository<Doacao, String>{
	Iterable<Doacao> findByDoador(Doador doador);
	Doacao findByIdDoacao(long idDoacao);
}
