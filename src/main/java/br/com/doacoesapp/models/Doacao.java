package br.com.doacoesapp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;




@Entity
public class Doacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idDoacao;
		
	@NotEmpty
	private String tipoItem;
	
	@NotEmpty
	private String nomeDoacao;
	
	@ManyToOne
	private Doador doador;

	public long getIdDoacao() {
		return idDoacao;
	}

	public void setIdDoacao(long idDoacao) {
		this.idDoacao = idDoacao;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
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
