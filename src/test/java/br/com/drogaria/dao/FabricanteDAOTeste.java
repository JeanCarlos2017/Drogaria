package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.entidade.Fabricante;
import br.com.drograria.dao.FabricanteDAO;


public class FabricanteDAOTeste {
	@Test @Ignore
	public void salvar() {
		FabricanteDAO salvarFabricante = new FabricanteDAO();
		Fabricante fabricante = new Fabricante("Anador");
		salvarFabricante.salvar(fabricante);
		
	}
	
	
	@Test @Ignore
	public void listarFabricantes() {
		FabricanteDAO lista = new FabricanteDAO();
		List<Fabricante> result = lista.buscarPorCampo("descricao", "Doril");
		for (Fabricante f: result) System.out.println(f.toString());
	}
	
	@Test
	public void updateFabricante() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante novoFabricante = new Fabricante();
		novoFabricante = fabricanteDAO.buscarPorCodigo(8L);
		if (novoFabricante != null) {
			System.out.println("O registro:");;
			System.out.println(novoFabricante.toString());
			//alterando
			novoFabricante.setDescricao("Benegrip");
			fabricanteDAO.alterar(novoFabricante);
			//exibindo
			System.out.println("Foi trocado por: ");
			System.out.println(novoFabricante.toString());
		}else {
			System.out.println("Não foi possível encontrar o registro, portanto não houve alteração.");
		}
		
	}
	
}
