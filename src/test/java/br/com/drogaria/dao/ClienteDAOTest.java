package br.com.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.drogaria.entidade.Cliente;
import br.com.drogaria.entidade.Pessoa;
import br.com.drograria.dao.ClienteDAO;
import br.com.drograria.dao.PessoaDAO;

public class ClienteDAOTest {
	@Test 
	public void salvar() {
	   //buscar pessoa 
		Long codigoPessoa = 27L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscarPorCodigo(codigoPessoa);
	   //criando o cliente	
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente(new Date(), true, pessoa);
		clienteDAO.salvar(cliente);
	}
	@Test @Ignore
	public void buscarPessoaCliente() {
		//busca pessoas que já são clientes, para evitar que um pessoa tenha dois clientes 
		Long codigoPessoa = 26L;//código paula <3
		//PessoaDAO pessoaDAO = new PessoaDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> listaCLiente = clienteDAO.buscarPorCampo("pessoa_codigo", codigoPessoa);
		for (Cliente c: listaCLiente) System.out.println(c.toString());
	}
	
	@Test @Ignore
	public void listarClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> listaCliente = clienteDAO.listar();
		for (Cliente c: listaCliente) System.out.println(c.toString());
	}
	
	@Test @Ignore
	public void excluirCliente() {
		//buscar pessoa 
		Long codigoCliente = 31L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscarPorCodigo(codigoCliente);
		
		if (cliente == null) {
			System.out.println("Erro! Código de cliente não encontrado");
		}else {
			System.out.println(cliente.toString());
			clienteDAO.excluir(cliente);
		}
	}
}
