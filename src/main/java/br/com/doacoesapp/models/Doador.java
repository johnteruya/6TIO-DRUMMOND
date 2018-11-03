package br.com.doacoesapp.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Doador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idDoador;

	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String local;
	
	@NotEmpty
	private String data;

	@NotEmpty
	private String horario;
	
	@OneToMany
	private List<Doacao> doacao;

	
	
	public long getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(long idDoador) {
		this.idDoador = idDoador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Doacao> getDoacao() {
		return doacao;
	}

	public void setDoacao(List<Doacao> doacao) {
		this.doacao = doacao;
	}
	
}
