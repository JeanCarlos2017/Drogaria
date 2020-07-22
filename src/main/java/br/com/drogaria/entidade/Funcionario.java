package br.com.drogaria.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {
	
	public Funcionario() {}
	public Funcionario(String carteiraDeTrabalho, Date dataAdmissao, Pessoa pessoa) {
		super();
		this.carteiraDeTrabalho = carteiraDeTrabalho;
		this.dataAdmissao = dataAdmissao;
		this.pessoa = pessoa;
	}


	@Column (length = 15, nullable = false)
	private String carteiraDeTrabalho;
	
	@Temporal(TemporalType.DATE) @Column(nullable = false)
	private Date dataAdmissao; 
	
	@OneToOne @JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	@Override
	public String toString() {
		return "\n"+this.pessoa.toString()+
				"\nData de adimissão: "+this.dataAdmissao+
				"\nCarteira de Trabalho: "+this.carteiraDeTrabalho+"\n\n";
		
	}
	
	//getters and setters 
	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
