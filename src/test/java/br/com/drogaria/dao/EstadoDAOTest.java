package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.entidade.Estado;
import br.com.drograria.dao.EstadoDAO;


public class EstadoDAOTest {
	@Test @Ignore	
	public void salvar() {
		//Estado estado = new Estado("SP", "São Paulo");
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);		
	}
	
	@Test @Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		for (Estado estado: resultado) System.out.println(estado.toString());
	}
	
	@Test @Ignore
	public void buscar() {
		Long codigo = 2L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado resultado = estadoDAO.buscarPorCodigo(codigo);
		
		if (resultado == null) System.out.println("Nenhum resultado encontrado \n");
		else System.out.println("Encontrado \n"+resultado.toString());
	}
	
	@Test @Ignore
	public void buscarEstadoPorNome () {
		String s = "Rio de Janeiro";
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.buscarEstadoPorNome(s);
		for (Estado e: resultado) System.out.println(e.toString());
	}
	
	@Test @Ignore
	public void buscarEstadoPorNomeCampo () {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.buscarPorCampo("sigla", "RJ");
		for (Estado e: resultado) System.out.println(e.toString());
	}
	
	@Test 
	public void excluir() {
		Long codigo = 6L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado resultado = estadoDAO.buscarPorCodigo(codigo);
		if (resultado != null) { 
			System.out.println("O registro: \n"+resultado);
			System.out.println("Foi removido com sucesso!");
			estadoDAO.excluir(resultado);
		}else {
			System.out.println("Não encontramos nenhum registro correspondente, portanto não houve a exclusão");
		}
	}
}
