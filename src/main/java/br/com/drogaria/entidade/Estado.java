package br.com.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain{
	@Column(length = 2, nullable = false)
	private String sigla;
	@Column(length = 30, nullable = false)
	private String nome;
	
	public Estado() {}
	public Estado(String sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String s="==============================="+
				"\nCódigo: "+this.getCodigo()+
				"\nNome: "+this.nome+
				"\nSigla: "+this.sigla+
				"\n===============================\n";
		return s;
	}
	
   //getters e setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}
	
	
}
