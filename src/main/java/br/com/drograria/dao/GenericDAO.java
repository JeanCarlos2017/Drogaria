package br.com.drograria.dao;

import java.lang.reflect.ParameterizedType;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import br.com.drogaria.util.HibernateUtil;

public class GenericDAO <Entidade> {
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		//reflection
		try {
			this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}catch (Exception e) {
			// TODO: handle exception
			//throw e;
			//System.out.println("Erro reflection: "+e);
		}
				
	}
	
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		}catch (RuntimeException error) {
			// TODO: handle exception
			if (transacao != null) transacao.rollback();
			System.out.println("não foi possível salvar a entidade. Erro: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}
	
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			
			// Create CriteriaBuilder
	           CriteriaBuilder builder = sessao.getCriteriaBuilder();
	           
	        // Create CriteriaQuery
	           CriteriaQuery<Entidade> consulta = builder.createQuery(classe);
	    
	        // Specify criteria root
	          consulta.from(classe);
	    
	        // Execute query
	          List<Entidade> resultado = sessao.createQuery(consulta).getResultList();
	          
	          return resultado;
	    
	      } catch (RuntimeException error) {
			// TODO: handle exception
			System.out.println("Não foi possível fazer a lista. Erro: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}
	
	public Entidade buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Entidade resultado = null;
	    try {
	        resultado = sessao.find(classe, codigo);
	        return resultado;     
	      }catch (RuntimeException error) {
	      // TODO: handle exception
	      System.out.println("Não foi possível fazer a busca. Erro: "+error);
	      throw error;
	    }finally {
	      sessao.close();
	    }
	}
	
	public List<Entidade> buscarPorCampo(String nomeCampo, Object valorCampo){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			 CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Entidade> query = builder.createQuery(classe);
	         Root<Entidade> root = query.from(classe);
	         query.select(root).where(builder.equal(root.get(nomeCampo), valorCampo));
	         Query<Entidade> q = session.createQuery(query);
	         List<Entidade> result = q.getResultList();
	         
	         return result;
	         
	    }catch (RuntimeException error) {
			// TODO: handle exception
			System.out.println("Não foi possível fazer a busca. Erro: "+error);
			throw error;
		}finally {
			session.close();
		}
	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		}catch (RuntimeException error) {
			// TODO: handle exception
			if (transacao != null) transacao.rollback();
			System.out.println("não foi possível salvar a entidade. Erro: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}
	
	public void alterar (Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		}catch (RuntimeException error) {
			// TODO: handle exception
			if (transacao != null) transacao.rollback();
			System.out.println("não foi possível salvar a entidade. Erro: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}

	public long getQntEntidadeCadastrada (Entidade entidade) {
		//conta quntos cadastros tem uma entidade
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			//contando a quantidade de cadastros 
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
			Root<Entidade> root = criteriaQuery.from(classe);
	        criteriaQuery.select(builder.count(root));
	        Query<Long> query = sessao.createQuery(criteriaQuery);
	        long count = query.getSingleResult();
	        transacao.commit();
	        return count;
		}catch (RuntimeException error) {
			// TODO: handle exception
			if (transacao != null) transacao.rollback();
			System.out.println("não foi possível obter a quantidade de entidades cadastradas. Erro: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}
	
	public Object getValorMaximo(Entidade entidade, String campo) {
				//retorna o valor máximo dos remédios, das vendas, depende do campo informado.. 
				Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
				Transaction transacao = null;
				try {
					transacao = sessao.beginTransaction();
					//construindo o criteria builder
					CriteriaBuilder builder = sessao.getCriteriaBuilder();
					//criando a requisição
					CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
					//informando a entidade que terá a requisição
					Root<Entidade> root = criteriaQuery.from(classe);
			        //criando a requisição (informando o que será selecionado)
					criteriaQuery.select(builder.max(root.get(campo)));
					//fazendo a requisição
			        Query<Long> query = sessao.createQuery(criteriaQuery);
			        //obtendo o resultado
			        Object valorMax= query.getSingleResult();
			        transacao.commit();
			        return valorMax;
				}catch (RuntimeException error) {
					// TODO: handle exception
					if (transacao != null) transacao.rollback();
					System.out.println("não foi possível obter o valor máximo do campo:  "+campo+". Erro: "+error);
					throw error;
				}finally {
					sessao.close();
				}
	}
	
	public Object getValorMedio(Entidade entidade, String campo) {
		//retorna o valor médio dos remédios, das vendas, depende do campo informado.. 
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			//construindo o criteria builder
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			//criando a requisição
			CriteriaQuery<Double> criteriaQuery = builder.createQuery(Double.class);
			//informando a entidade que terá a requisição
			Root<Entidade> root = criteriaQuery.from(classe);
	        //criando a requisição (informando o que será selecionado)
			criteriaQuery.select(builder.avg(root.get(campo)));
			//fazendo a requisição
	        Query<Double> query = sessao.createQuery(criteriaQuery);
	        //obtendo o resultado
	        Object avg= query.getSingleResult();
	        transacao.commit();
	        return avg;
		}catch (RuntimeException error) {
			// TODO: handle exception
			if (transacao != null) transacao.rollback();
			System.out.println("não foi possível obter o valor médio do campo:  "+campo+". Erro: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}
	
	public Object getQntRegistrosDistintos(Entidade entidade) {
		//retorna o valor médio dos remédios, das vendas, depende do campo informado.. 
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			//construindo o criteria builder
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			//criando a requisição
			CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
			//informando a entidade que terá a requisição
			Root<Entidade> root = criteriaQuery.from(classe);
	        //criando a requisição (informando o que será selecionado)
			criteriaQuery.select(builder.countDistinct(root));
			//fazendo a requisição
	        Query<Long> query = sessao.createQuery(criteriaQuery);
	        //obtendo o resultado
	        Object avg= query.getSingleResult();
	        transacao.commit();
	        return avg;
		}catch (RuntimeException error) {
			// TODO: handle exception
			if (transacao != null) transacao.rollback();
			System.out.println("não foi possível obter o número de registros distintos. Error: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}
	
	public Object getQntRegistrosDistintosPorCampo(Entidade entidade, String campo) {
		//retorna o valor médio dos remédios, das vendas, depende do campo informado.. 
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			//construindo o criteria builder
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			//criando a requisição
			CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
			//informando a entidade que terá a requisição
			Root<Entidade> root = criteriaQuery.from(classe);
	        //criando a requisição (informando o que será selecionado)
			criteriaQuery.select(builder.countDistinct(root.get(campo)));
			//fazendo a requisição
	        Query<Long> query = sessao.createQuery(criteriaQuery);
	        //obtendo o resultado
	        Object avg= query.getSingleResult();
	        transacao.commit();
	        return avg;
		}catch (RuntimeException error) {
			// TODO: handle exception
			if (transacao != null) transacao.rollback();
			System.out.println("não foi possível obter o número de registros distintos de acordo com o campo "+campo+". Error: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}
	
	public void teste01 (){
		//Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		//Transaction transacao = null;
		
		
	}
	
	/*
	 * public List<Entidade> testJoin(Long codigoPessoa) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			//construindo o criteria builder
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
			Root<Cliente> root = criteriaQuery.from(Cliente.class);
			Join<Pessoa, Cliente> join = root.join("cliente_pessoa");
			EntityType<Cliente> Pessoa_ = root.getModel();
			criteriaQuery.where(criteriaQuery.equal(join.get(Pessoa_.getc), codigoPessoa));
			
			transacao.commit();
		}catch (RuntimeException error) {
			// TODO: handle exception
			if (transacao != null) transacao.rollback();
			System.out.println("Teste Join falhou. Erro: "+error);
			throw error;
		}finally {
			sessao.close();
		}
	}
	*/

}
