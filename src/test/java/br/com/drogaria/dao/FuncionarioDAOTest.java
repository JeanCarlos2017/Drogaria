package br.com.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.entidade.Funcionario;
import br.com.drogaria.entidade.Pessoa;
import br.com.drograria.dao.FuncionarioDAO;
import br.com.drograria.dao.PessoaDAO;

public class FuncionarioDAOTest {
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	@Test @Ignore
	public void salvarFuncionario() {
	   //buscar pessoa 
		Long codigoPessoa = 27L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscarPorCodigo(codigoPessoa);
	   //salvarFuncionario 
		//FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario("cartTrabalho", new Date(), pessoa);
		funcionarioDAO.salvar(funcionario);		
	}
	
	@Test
	public void listarFuncionario() {
		List<Funcionario> listaFuncionario = funcionarioDAO.listar();
		for (Funcionario f: listaFuncionario) System.out.println(f.toString());
		
	}
	
}
