package br.com.drogaria.entidade;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass //informa que nao corresponde a uma tabela, mas é usada por outros para criar uma tabela 
public class GenericDomain implements Serializable {
	@Id //chave primária 
	@GeneratedValue(strategy = GenerationType.AUTO) //auto incremento
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
