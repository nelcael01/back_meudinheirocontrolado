INSERT INTO usuario (id_usuario, cpf, endereco, nome, senha, telefone) 
VALUES 
(1,"03924709181", "Rua Antonio Batista", "Nelcael", "senha123", "993516160"),
(2,"55555555555", "Rua belo horizonte", "Ludmila", "senha890", "999999999");

INSERT INTO tipo_entrada (id_tipo_entrada, nome, descricao) 
VALUES 
(1,"Salario", "valor fixo no final/inicio do mês"),
(2,"Outros", "valor variavel que pode ser ganho em todo o mês");

INSERT INTO tipo_moeda (id_tipo_moeda, nome) 
VALUES 
(1,"Real"),
(2,"Euro");

INSERT INTO categoria_despesa (id_categoria_despesa, descricao) 
VALUES 
(1,"Necessidades"),
(2,"Afins");