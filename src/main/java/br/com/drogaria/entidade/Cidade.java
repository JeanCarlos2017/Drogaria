package br.com.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain {
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn (nullable = false)
	private Estado estado;
	
	public Cidade() {}
	public Cidade(Estado estado, String nome) {
		this.estado = estado;
		this.nome = nome;
	}
	@Override
	public String toString() {
		return  "\nNome: "+this.nome + 
					" |Código cidade: "+this.getCodigo()+
					"\n"+this.estado.toString()+"\n";
	}
   //getters and setters 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	} 
	
	

}
