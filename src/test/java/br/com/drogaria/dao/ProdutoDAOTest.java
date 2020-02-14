package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.drogaria.entidade.Fabricante;
import br.com.drogaria.entidade.Produto;
import br.com.drograria.dao.FabricanteDAO;
import br.com.drograria.dao.ProdutoDAO;


public class ProdutoDAOTest {
	
	
	@Test @Ignore
	public void salvarProduto() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
	   //BUSCANDO O FABRICANTE	
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricanteProduto = fabricanteDAO.buscarPorCodigo(7L);
		
		if (fabricanteProduto == null) System.out.println("Erro! Código produto não encontrado");
		else {
		   //criando o produto	
			Produto produto = new Produto("Cartela 10 comprimidos", new Short("600"), new BigDecimal("7.20"), fabricanteProduto);
			produtoDAO.salvar(produto);
		}
	}
	
	@Test @Ignore
	public void listarProduto() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> listaDeProduto = produtoDAO.listar();
		for (Produto p: listaDeProduto) System.out.println(p.toString());
	}
	
	@Test @Ignore
	public void buscarProdutoPorQuantidade() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> listaDeProduto = produtoDAO.buscarPorCampo("quantidade", 600);
		for (Produto p: listaDeProduto) System.out.println(p.toString());
	}
	
	@Test @Ignore
	public void buscarCidadePorCodigo() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(20L);
		System.out.println(produto.toString());
	}
	
	@Test @Ignore
	public void deletarProduto() {
	  //encontra do produto	
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Long codigoProduto= 17L;
		Produto produto = produtoDAO.buscarPorCodigo(codigoProduto);
		
		if (produto == null) System.out.println("Erro! Código do produto não encontrado!");
		else {
			System.out.println(produto.toString());
			produtoDAO.excluir(produto);
		}
	}
	
	@Test @Ignore
	public void alterarProduto() {
	   //buscando o fabricante
		Long codigoFabricante = 7L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(codigoFabricante);
		
	  //buscando produto 
		Long codigoProduto = 19L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(codigoProduto);
		
		if ((fabricante == null) || (produto == null)) System.out.println("Erro! Código de fabricante e/ou produto não encontrado!");
		else {
			System.out.println(produto.toString());
			produto.setQuantidade(new Short("1200"));
			produto.setFabricante(fabricante);
			produtoDAO.alterar(produto);
			System.out.println(produto.toString());
		}
	}
	@Test @Ignore
	public void valorMaxProduto() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Object res = produtoDAO.getValorMaximo(new Produto(), "preco");
		System.out.println("Valor máximo dos produtos: "+res+"\n\n");
	}
	
	@Test @Ignore
	public void contadorProduto() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		long res = produtoDAO.getQntEntidadeCadastrada(new Produto());
		System.out.println("Quantidade de produtos cadastrados é igual a: "+res+"\n\n");
	}
	@Test @Ignore
	public void mediaPrecoProduto() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Object res = produtoDAO.getValorMedio(new Produto(), "preco");
		System.out.println("Valor médio dos produtos: "+res+"\n\n");
	}
	
	@Test
	public void contadorDeRegistrosDistintos() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Object res = produtoDAO.getQntRegistrosDistintos(new Produto());
		System.out.println("Quantidade de produtos distintos cadastrados é igual a: "+res+"\n\n");
	}
	
	@Test
	public void contadorDeRegistrosDistintosPorCampo() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Object res = produtoDAO.getQntRegistrosDistintosPorCampo(new Produto(), "preco");
		System.out.println("Quantidade de produtos cadastrados com preços diferentes é igual a: "+res+"\n\n");
	}
}
