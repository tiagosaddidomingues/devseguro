Drop table stj.cliente;
Drop table stj.produto;
drop table stj.pedido;

CREATE TABLE stj.cliente (
  id_cliente int NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  senha varchar(10) NOT NULL,
  eMail varchar(50)  NULL,
  telefone varchar (20) NULL,
  endereco varchar (100) NULL,
  
  PRIMARY KEY (id_cliente)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE stj.produto (
  id_produto int NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  descricao varchar(200) NOT NULL,
  preco Decimal(10,2) NULL,
  
  PRIMARY KEY (id_produto)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE stj.Pedido (
  id_cliente int NOT NULL,
  id_produto int NOT NULL,
  quantidade int NOT NULL,
  preço_unitario DECIMAL(10,2) NOT NULL,
  data_compra date NOT NULL,
  
  PRIMARY KEY (id_cliente,id_produto)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
