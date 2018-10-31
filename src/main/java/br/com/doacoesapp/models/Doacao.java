package br.com.doacoesapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;




@Entity
public class Doacao {

	@Id 
	@NotEmpty
	private String rg;
	
	@NotEmpty
	private String nomeDoacao;
	
	@ManyToOne
	private Doador doador;

	
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeDoacao() {
		return nomeDoacao;
	}

	public void setNomeDoacao(String nomeDoacao) {
		this.nomeDoacao = nomeDoacao;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	
}
