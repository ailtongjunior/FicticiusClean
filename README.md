# FicticiusClean

FicticiusClean - cadastro de veículos e previsão de gastos.

Métodos: cadastraVeiculo, calculaGastos.

Foi utilizado o banco de dados MySQL versão 8.0.23.
Scripts para geração da estrutura no banco:

  CREATE USER 'FicticiusClean'@'%' IDENTIFIED BY 'FicticiusClean';

  GRANT ALL PRIVILEGES ON FicticiusClean.* TO FicticiusClean;

  CREATE TABLE veiculos(idveiculos INT NOT NULL AUTO_INCREMENT
    ,nome VARCHAR(50)
      ,marca VARCHAR(50)
      ,modelo VARCHAR(50)
      ,datafabricacao DATETIME
      ,ConsumoMedioCidade FLOAT
      ,ConsumoMedioRodovia FLOAT
      ,PRIMARY KEY(idveiculos)
  );

Para os testes foi utilizado o aplicativo Postman(https://www.postman.com/downloads/).
O envio e retorno das informações é no formato JSON.

Utilizando o Postman é possível consultar as instruções de utilização. 
Para isso basta configurar a requisição como GET e adicionar a URL: http://localhost:8080/FicticiusClean/webresources/FicticiusCleanWS/

Exemplo de chamada para cadastrar um veículo:
  1) - Configurar no Postman o tipo de requisição como PUT.
  2) - Adicionar a URL: http://localhost:8080/FicticiusClean/webresources/FicticiusCleanWS/cadastraVeiculo
  3) - Selecionar abaixo da URL a opção Body.
  4) - Selecionar a opção raw e escolher o formato JSON.
  5) - Preencher os parâmetros conforme exemplo.
        {
        "Nome": "Nome do veículo" <!-- String -->,
        "Marca": "Marca do veículo" <!-- String -->,
        "Modelo": "Modelo do veículo" <!-- String -->,
        "DataFabricacao":"Data de fabricação do veículo no formato aaaa-MM-dd" <!-- Date -->,
        "ConsumoMedioCidade": Consumo médio de combustível dentro da cidade <!-- float -->,
        "ConsumoMedioRodovia": Consumo médio de combustível em rodovias <!-- float -->
      }
      
      
Exemplo de chamda para calcular previsão de gastos.
  1) - Configurar no Postman o tipo de requisição para GET.
  2) - Adicionar a URL: http://localhost:8080/FicticiusClean/webresources/FicticiusCleanWS/calculaGastos
  3) - Selecionar abaixo da URL a opção Body.
  4) - Selecionar a opção raw e escolher o formato JSON.
  5) - Preencher os parâmetros conforme exemplo.
        {
        "PrecoGas": Preço do combustível <!-- float -->,
        "KmCidade": Quantidade de quilômetros rodados na cidade <!-- float -->,
        "KmRodovia": Quantidade de quilômetros rodados em rodovias <!-- float -->
      }
      
