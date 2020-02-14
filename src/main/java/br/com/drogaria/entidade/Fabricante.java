package br.com.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Fabricante extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public Fabricante() {}
	public Fabricante(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "\nCódigo do Fabricante: "+this.getCodigo()+
				"| Descrição do Fabricante: "+this.descricao+"\n";
	}
   //getters and setters 
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}