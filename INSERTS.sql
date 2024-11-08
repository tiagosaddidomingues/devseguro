INSERT INTO stj.cliente (id_cliente,nome,senha,eMail,telefone,endereco)
VALUES
(1,'Tiago',11111,'tiago.saddi@gmail.com','61-11111-1111','SQSW 301, Bloco 1, Apartamento 111'),
(2,'Michello',22222,'michello.almeida@gmail.com','61-22222-2222','SQN 327, Bloco 2, Apartamento 222'),
(3,'Ronald',33333,'ronald@gmail.com','61-33333-3333','SQN 303, Bloco 3, Apartamento 333'),
(4,'Leo',44444,'leo@gmail.com','61-44444-4444','SQN 304, Bloco 4, Apartamento 444')
;

select * from stj.cliente;

INSERT INTO `stj`.`produto` (`id_produto`,`nome`,`descricao`,`preco`,`peso`,`quantidade`)
VALUES
(1,'Casaco','Casaco de frio.',123.20,1.5,5),
(2,'Blusa','Blusa de linho.',211.10,0.5,5),
(3,'Cueca','Cueca de algodao.',32.20,0.2,5),
(4,'Sandalia','Sandalia de couro.',101.20,0.5,5),
(5,'Lenco','Lenco de seda.',200.20,0.1,5);


select * from stj.produto;