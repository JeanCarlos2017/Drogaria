package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.entidade.Cidade;
import br.com.drogaria.entidade.Estado;
import br.com.drograria.dao.CidadeDAO;
import br.com.drograria.dao.EstadoDAO;

public class CidadeDAOTest {
	private Cidade cidade;
	private CidadeDAO cidadeDAO = new CidadeDAO();

	@Test @Ignore
	public void salvarCidade() {
		String nomeCidade = "Poá";
		//Cidade cidade;
		//busca o estado 
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscarPorCodigo(codigo);
				
		if (estado == null) {
		// se nao encontra o estado nao pode salvar a cidade
			System.out.println("Estado informado está incorreto, portanto nao foi salva a cidade \n");
		}else {
			System.out.println("Encontrado o estado \n"+estado.toString());
			cidade = new Cidade(estado, nomeCidade);
			cidadeDAO.salvar(cidade);
			System.out.println("Salvando a cidade");
		}
	}
	
	@Test @Ignore
	public void listarCidade() {
		List<Cidade> listaDeCidades = cidadeDAO.listar();
		for (Cidade c: listaDeCidades) System.out.println(c.toString());
	}
	
	@Test @Ignore
	public void buscarCidadePorNome() {
		String nomeCidade = "Poá";
		List<Cidade> listaDeCidades = cidadeDAO.buscarPorCampo("nome", nomeCidade);
		for (Cidade c: listaDeCidades) System.out.println(c.toString());
	}
	
	@Test @Ignore
	public void buscarCidadePorCodigo() {
		Long codigoCidade = 14L;
		cidade = cidadeDAO.buscarPorCodigo(codigoCidade);
		if (cidade == null) System.out.println("Código de cidade não encontrado!");
		else System.out.println(cidade.toString());
	}
	
	@Test @Ignore
	public void deletarCidade() {
		Long codigoCidade = 14L;
		cidade = cidadeDAO.buscarPorCodigo(codigoCidade);
		if (cidade == null) System.out.println("Erro! Código de cidade não encontrado!");
		else {
			System.out.println(cidade.toString());
			cidadeDAO.excluir(cidade);
		}
	}
	
	@Test @Ignore
	public void alterarNomeCidade() {
		Long codigoCidade = 12L;
		cidade = cidadeDAO.buscarPorCodigo(codigoCidade);
		if (cidade == null) System.out.println("Erro! Código de cidade não encontrado!");
		else {
			System.out.println(cidade.toString());
			cidade.setNome("Mogi Mirim");
			cidadeDAO.alterar(cidade);
		}
	}
	
	@Test
	public void alterarEstadoDaCidade() {
	   //buscando o estado
		Long codigoEstado = 2L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado novoEstado = estadoDAO.buscarPorCodigo(codigoEstado);
		
	  //buscandoCidade 
		Long codigoCidade = 12L;
		cidade = cidadeDAO.buscarPorCodigo(codigoCidade);
		
		if ((novoEstado == null) || (cidade == null)) System.out.println("Erro! Código de estado e/ou cidade não encontrado!");
		else {
			System.out.println(cidade.toString());
			cidade.setNome("Rio de Janeiro");
			cidade.setEstado(novoEstado);
			cidadeDAO.alterar(cidade);
		}
	}
}
