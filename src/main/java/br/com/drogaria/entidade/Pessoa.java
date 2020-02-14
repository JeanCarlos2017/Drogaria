package br.com.drogaria.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;


@SuppressWarnings("serial")
@Entity
public class Pessoa extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 14, nullable = false)
	private String cpf;
	
	@Column(length = 12, nullable = false)
	private String rg;
	
	@Column(length = 100, nullable = false)
	private String rua;
	
	@Column(nullable = false)
	private Short numero;
	
	@Column(length = 30, nullable = false)
	private String bairro;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@Column(length = 10, nullable = false)
	private String complemento;
	
	@Column(length = 13, nullable = false)
	private String telefone;

	@Column(length = 14, nullable = false)
	private String celular;
	
	@Column(length = 100, nullable = false)
	private String email;

	public String getNome() {
		return nome;
	}
	
	 @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL,
              fetch = FetchType.LAZY, optional = true)
    private Cliente cliente;
	/*
	@OneToOne
	@JoinColumn()
	private Funcionario funcionario; */
	
	public Pessoa() {};
	public Pessoa(String nome, String cpf, String rg, String rua, Short numero, String bairro, 
			String cep, String complemento, String telefone, String celular, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nNome da pessoa: "+nome+
				"\nCódigo Pessoa: "+this.getCodigo()+
				"\nCPF: "+this.cpf+
				"\nRG: "+this.rg+
				"\nRua: "+this.rua+
				"\nNumero de casa: "+this.rua+"| Complemento: "+this.complemento+
				"\nBairro "+this.bairro+
				"\nCEP: "+this.cep+
				"Celular: "+this.celular+
				"Email: "+this.email+"\n";
	}
   //getters and setters 
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
