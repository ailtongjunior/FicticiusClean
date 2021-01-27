package br.com.FicticiusClean.dao;

import java.util.List;

import br.com.FicticiusClean.model.PrevisaoGastos;
import br.com.FicticiusClean.model.RetornoPrevisao;
import br.com.FicticiusClean.model.Veiculo;

public interface VeiculoDAO {

	public void adicionarVeiculo(Veiculo veiculo);
	public List<RetornoPrevisao> retornoPrevisao(PrevisaoGastos previsaoGastos);
}
