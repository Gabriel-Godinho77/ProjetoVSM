CREATE TABLE pessoas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpfOrCnpj VARCHAR(15) NOT NULL UNIQUE,
    endereco VARCHAR(50),
    numero VARCHAR(20),
    bairro VARCHAR(100),
    cep VARCHAR(9),
    cidade VARCHAR(100),
    uf CHAR(2),
    telefone VARCHAR(11),
    email VARCHAR(50),
    PRIMARY KEY (id)
);



