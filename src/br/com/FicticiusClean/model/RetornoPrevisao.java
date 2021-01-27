package br.com.FicticiusClean.model;

public class RetornoPrevisao {

	private String Nome;
	private String Marca;
	private String Modelo;
	private Integer Ano;
	private float QuantidadeCombustivelGasto;
	private float ValorTotalCombustivel;
	
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
	
	public Integer getAno() {
		return Ano;
	}
	public void setAno(Integer ano) {
		Ano = ano;
	}
	
	public float getQuantidadeCombustivelGasto() {
		return QuantidadeCombustivelGasto;
	}
	public void setQuantidadeCombustivelGasto(float quantidadeCombustivelGasto_) {
		this.QuantidadeCombustivelGasto = quantidadeCombustivelGasto_;
	}
	
	public float getValorTotalCombustivel() {
		return ValorTotalCombustivel;
	}
	public void setValorTotalCombustivel(float valorTotalCombustivel_) {
		this.ValorTotalCombustivel = valorTotalCombustivel_;
	}	
}
