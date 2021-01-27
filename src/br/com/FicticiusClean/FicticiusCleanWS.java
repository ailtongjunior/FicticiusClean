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
	@Produces("application/text")
	public String getFicticiusClean() {
		return "Métodos: cadastraVeiculo, calculaGastos.\r\n"
				+ "\r\n"
				+ "Para os testes foi utilizado o aplicativo Postoman.\r\n"
				+ "O envio e retorno das informações é no formato JSON.\r\n"
				+ "\r\n"
				+ "Exemplo de chamada para cadastrar um veículo:\r\n"
				+ "  1) - Configurar no Postman o tipo de requisição como PUT.\r\n"
				+ "  2) - Adicionar a URL: http://localhost:8080/FicticiusClean/webresources/FicticiusCleanWS/cadastraVeiculo.\r\n"
				+ "  3) - Selecionar abaixo da URL a opção Body.\r\n"
				+ "  4) - Selecionar a opção raw e escolher o formato JSON.\r\n"
				+ "  5) - Preencher os parâmetros conforme exemplo.\r\n"
				+ "        {\r\n"
				+ "        \"Nome\": \"Nome do veículo\" <!-- String -->,\r\n"
				+ "        \"Marca\": \"Marca do veículo\" <!-- String -->,\r\n"
				+ "        \"Modelo\": \"Modelo do veículo\" <!-- String -->,\r\n"
				+ "        \"DataFabricacao\":\"Data de fabricação do veículo no formato aaaa-MM-dd\" <!-- Date -->,\r\n"
				+ "        \"ConsumoMedioCidade\": Consumo médio de combustível dentro da cidade <!-- float -->,\r\n"
				+ "        \"ConsumoMedioRodovia\": Consumo médio de combustível em rodovias <!-- float -->\r\n"
				+ "      }\r\n"
				+ "      \r\n"
				+ "      \r\n"
				+ "Exemplo de chamda para calcular previsão de gastos.\r\n"
				+ "  1) - Configurar no Postman o tipo de requisição para GET.\r\n"
				+ "  2) - Adicionar a URL: http://localhost:8080/FicticiusClean/webresources/FicticiusCleanWS/calculaGastos\r\n"
				+ "  3) - Selecionar abaixo da URL a opção Body.\r\n"
				+ "  4) - Selecionar a opção raw e escolher o formato JSON.\r\n"
				+ "  5) - Preencher os parâmetros conforme exemplo.\r\n"
				+ "        {\r\n"
				+ "        \"PrecoGas\": Preço do combustível <!-- float -->,\r\n"
				+ "        \"KmCidade\": Quantidade de quilômetros rodados na cidade <!-- float -->,\r\n"
				+ "        \"KmRodovia\": Quantidade de quilômetros rodados em rodovias <!-- float -->\r\n"
				+ "      }!";
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
