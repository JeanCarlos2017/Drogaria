package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.entidade.Cliente;
import br.com.drogaria.entidade.Pessoa;
import br.com.drogaria.entidade.Usuario;
import br.com.drograria.dao.ClienteDAO;
import br.com.drograria.dao.PessoaDAO;
import br.com.drograria.dao.UsuarioDAO;

public class UsuarioDAOTest {
	@Test @Ignore
	public void salvar() {
		//buscar pessoa 
		Long codigoPessoa = 25L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscarPorCodigo(codigoPessoa);
		//salvar o usuario
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario("senha", 'A', false, pessoa);
		usuarioDAO.salvar(usuario);
	}
	
	@Test @Ignore
	public void buscarUsuario() {
		//busca pessoas que já são usuários, para evitar que um pessoa tenha dois usuários
		Long codigoPessoa = 44L;//código usuario Jean
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(codigoPessoa);
		System.out.println(usuario.toString());
	}
	
	@Test 
	public void listarUsuario() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> listaUsuario = usuarioDAO.listar();
		for (Usuario u: listaUsuario) System.out.println(u.toString());
	}
	
	@Test @Ignore
	public void alterarUsuario() {
		//buscar pessoa 
		Long codigoPessoa = 26L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscarPorCodigo(codigoPessoa);
		
		//buscando o usuario 
		Long codigoUsuario = 45L;//código usuario Jean
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(codigoUsuario);
		//alterando "pessoa" do usuário
		usuario.setPessoa(pessoa);
		usuarioDAO.alterar(usuario);
		
	}
	@Test @Ignore
	public void excluirUsuario() {
		//buscar o usuário
		Long codigoUsuario = 46L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(codigoUsuario);
		
		if (usuario == null) {
			System.out.println("Erro! Código de cliente não encontrado");
		}else {
			System.out.println(usuario.toString());
			usuarioDAO.excluir(usuario);
		}
	}
}
