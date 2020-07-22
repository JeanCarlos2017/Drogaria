package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.drogaria.entidade.Pessoa;
import br.com.drograria.dao.PessoaDAO;

public class PessoaDAOTest {
	
	@Test @Ignore
	public void salvar() {
		Pessoa pessoa = new Pessoa("Ruth", "123", "123", "nome rua", new Short("450"), "nome bairro", "cep", "complement", "telefone", "celular", "email");
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);	
	}
	@Test 
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		for (Pessoa pessoa: resultado) System.out.println(pessoa.toString());
	}
	
	@Test @Ignore
	public void buscarPorNome() {
		String nome = "Paula";
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.buscarPorCampo("nome", nome);
		for (Pessoa e: resultado) System.out.println(e.toString());
	}
	
	@Test @Ignore
	public void alterar() {
	  //buscar pessoa 
		Long codigoPessoa = 26L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscarPorCodigo(codigoPessoa);
		
		if (pessoa == null) {
			System.out.println("Erro! Código da pessoa não encontrado");
		}else {
			System.out.println(pessoa.toString());
			pessoa.setNome("Paula Princesa <3");
			pessoaDAO.alterar(pessoa);
			System.out.println(pessoa.toString());
		}
	}
	
	@Test @Ignore
	public void deletar() {
		//buscar pessoa 
				Long codigoPessoa = 30L;
				PessoaDAO pessoaDAO = new PessoaDAO();
				Pessoa pessoa = pessoaDAO.buscarPorCodigo(codigoPessoa);
				
				if (pessoa == null) {
					System.out.println("Erro! Código da pessoa não encontrado");
				}else {
					System.out.println(pessoa.toString());
					pessoaDAO.excluir(pessoa);
				}
	}
	
}
