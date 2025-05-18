CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    senha VARCHAR(255),
    email VARCHAR(255),
    status VARCHAR(50),
    apelido VARCHAR(100),
    data_nascimento DATE,
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP,
    tipo_usuario VARCHAR(50)
);

CREATE TABLE genero (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(100)
);

CREATE TABLE filme (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    diretor VARCHAR(255),
    ano_lancamento INT,
    genero_id BIGINT,
    duracao INT,
    produtora VARCHAR(255),
    classificacao VARCHAR(50),
    poster TEXT,
    CONSTRAINT fk_genero FOREIGN KEY (genero_id) REFERENCES genero(id)
);

CREATE TABLE genero_filme (
    id_genero BIGINT,
    id_filme BIGINT,
    PRIMARY KEY (id_genero, id_filme),
    CONSTRAINT fk_gen FOREIGN KEY (id_genero) REFERENCES genero(id),
    CONSTRAINT fk_film FOREIGN KEY (id_filme) REFERENCES filme(id)
);

CREATE TABLE avaliacao (
    id_usuario BIGINT,
    id_filme BIGINT,
    nota INTEGER,
    comentario TEXT,
    PRIMARY KEY (id_usuario, id_filme),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    CONSTRAINT fk_filme FOREIGN KEY (id_filme) REFERENCES filme(id)
);
