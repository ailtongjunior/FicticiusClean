package br.com.FicticiusClean.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.FicticiusClean.model.PrevisaoGastos;
import br.com.FicticiusClean.model.RetornoPrevisao;
import br.com.FicticiusClean.model.Veiculo;

public class VeiculoDAOImpl implements VeiculoDAO {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void adicionarVeiculo(Veiculo veiculo) {
		Session session = getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(veiculo);
			session.flush();
		} catch (RuntimeException ex) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			session.close();
		}

	}

	public List<RetornoPrevisao> retornoPrevisao(PrevisaoGastos previsaoGastos) {
		CriteriaQuery<Veiculo> criteria = getSessionFactory().getCriteriaBuilder().createQuery(Veiculo.class);
		criteria.select(criteria.from(Veiculo.class));

		List<Veiculo> veiculos = getSessionFactory().openSession().createQuery(criteria).getResultList();

		List<RetornoPrevisao> lista = new ArrayList<RetornoPrevisao>();

		for (Veiculo veiculo : veiculos) {
			RetornoPrevisao retornoPrevisao = new RetornoPrevisao();

			retornoPrevisao.setNome(veiculo.getNome());
			retornoPrevisao.setMarca(veiculo.getMarca());
			retornoPrevisao.setModelo(veiculo.getModelo());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(veiculo.getDataFabricacao());
			retornoPrevisao.setAno(calendar.get(Calendar.YEAR));
			retornoPrevisao
					.setQuantidadeCombustivelGasto((previsaoGastos.getKmCidade() / veiculo.getConsumoMedioCidade())
							+ (previsaoGastos.getKmRodovia() / veiculo.getConsumoMedioRodovia()));
			retornoPrevisao.setValorTotalCombustivel(
					((previsaoGastos.getKmCidade() / veiculo.getConsumoMedioCidade()) * previsaoGastos.getPrecoGas())
							+ ((previsaoGastos.getKmRodovia() / veiculo.getConsumoMedioRodovia())
									* previsaoGastos.getPrecoGas()));

			lista.add(retornoPrevisao);
		}

		lista.sort(new Comparator<RetornoPrevisao>() {
			@Override
			public int compare(RetornoPrevisao veiculo1, RetornoPrevisao veiculo2) {
				return veiculo1.getValorTotalCombustivel() > veiculo2.getValorTotalCombustivel() ? -1 : (veiculo1.getValorTotalCombustivel() < veiculo2.getValorTotalCombustivel()) ? 1 : 0;
			}
		});

		return lista;
	}
}
