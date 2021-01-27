package br.com.FicticiusClean;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import br.com.FicticiusClean.dao.VeiculoDAO;
import br.com.FicticiusClean.dao.VeiculoDAOImpl;
import br.com.FicticiusClean.model.PrevisaoGastos;
import br.com.FicticiusClean.model.Veiculo;

@Path("FicticiusCleanWS")
public class FicticiusCleanWS {

	@Context
	private UriInfo context;

	public FicticiusCleanWS() {

	}

	@GET
	@Produces("application/json")
	public String getFicticiusClean() {
		return "Sucesso!";
	}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("calculaGastos")
	public String calculaGastos(String json) {
		
		Gson gson = new Gson();
		
		VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
		
		return gson.toJson(veiculoDAO.retornoPrevisao(gson.fromJson(json, PrevisaoGastos.class)));
	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("cadastraVeiculo")
	public String cadastraVeiculo(String json) {
		try {
		Gson gson = new Gson();

		VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
		veiculoDAO.adicionarVeiculo(gson.fromJson(json, Veiculo.class));
		}
		catch(Exception ex) {
			return ex.getMessage();
		}
		
		return "Sucesso!";

	}

}
