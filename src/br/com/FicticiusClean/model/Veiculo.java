package br.com.FicticiusClean.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="veiculos")
public class Veiculo {
	
	@Id
	@Column(name="IdVeiculos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdVeiculos;

	@Column(name="Nome")
	private String Nome;
	
	@Column(name="Marca")
	private String Marca;
	
	@Column(name="Modelo")
	private String Modelo;
	
	@Column(name="DataFabricacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DataFabricacao;
	
	@Column(name="ConsumoMedioCidade")
	private float ConsumoMedioCidade;
	
	@Column(name="ConsumoMedioRodovia")
	private float ConsumoMedioRodovia;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome_) {
		this.Nome = nome_;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca_) {
		this.Marca = marca_;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo_) {
		this.Modelo = modelo_;
	}
	public Date getDataFabricacao() {
		return DataFabricacao;
	}
	public void setDataFabricacao(Date dataFabricacao_) {
		this.DataFabricacao = dataFabricacao_;
	}
	public float getConsumoMedioCidade() {
		return ConsumoMedioCidade;
	}
	public void setConsumoMedioCidade(float consumoMedioCidade_) {
		this.ConsumoMedioCidade = consumoMedioCidade_;
	}
	public float getConsumoMedioRodovia() {
		return ConsumoMedioRodovia;
	}
	public void setConsumoMedioRodovia(float consumoMedioRodovia_) {
		this.ConsumoMedioRodovia = consumoMedioRodovia_;
	}
}
