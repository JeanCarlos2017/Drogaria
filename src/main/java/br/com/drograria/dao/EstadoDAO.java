package br.com.drograria.dao;

import java.util.List;


import org.hibernate.Session;
import javax.persistence.criteria.*;


import org.hibernate.query.Query;

import br.com.drogaria.entidade.Estado;
import br.com.drogaria.util.HibernateUtil;

public class EstadoDAO extends GenericDAO <Estado>{
	//classe implementada em GenericDAO
	
	public List<Estado> buscarEstadoPorNome(String nomeEstado) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			 CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Estado> query = builder.createQuery(Estado.class);
	         Root<Estado> root = query.from(Estado.class);
	         query.select(root).where(builder.equal(root.get("nome"), nomeEstado));
	         Query<Estado> q = session.createQuery(query);
	         List<Estado> result = q.getResultList();
	         
	         return result;
	         
	    }catch (RuntimeException error) {
			// TODO: handle exception
			System.out.println("Não foi possível fazer a busca. Erro: "+error);
			throw error;
		}finally {
			session.close();
		}
	}
}
