CREATE DATABASE IF NOT EXISTS inngendb;

USE DATABASE inngendb;
 CREATE  TABLE IF NOT EXISTS user(
    id INT AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    login varchar(255) NOT NULL,
    senha valor(255) NOT NULL,
    cpf_cnpj varchar(255) NOT NULL,
    id_cliente INT,
    id_quartos INT,
    PRIMARY KEY (id)
 )

CREATE TABLE IF NOT EXISTS clientes(
    id INT AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    cpf varchar(255)NOT NULL,
    telefone varchar(255) NOT NULL,
    dt_nascimento date NOT NULL,
    PRIMARY KEY (id)
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)

)
CREATE TABLE IF NOT EXISTS quartos(
    id INT AUTO_INCREMENT,
    numero INT NOT NULL,
    tamanho int NOT NULL,
    valor DOUBLE NOT NULL,
    status varchar(255) NOT NULL,
    id_cliente INT,
    PRIMARY KEY (id)
    FOREIGN KEY (id_cliente) references clientes(id)
    FOREIGN KEY (id_quartos) REFERENCES Quartos(id)
)