package br.pro.oliveira.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.pro.oliveira.drogaria.domain.Cidade;
import br.pro.oliveira.drogaria.util.HibernateUtil;

public class CidadeDAO extends GenericDAO<Cidade> {
	@SuppressWarnings("unchecked")
	public List<Cidade> buscarPorEstado(Long estadoCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.codigo", estadoCodigo));	
			consulta.addOrder(Order.asc("nome"));
			List<Cidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}