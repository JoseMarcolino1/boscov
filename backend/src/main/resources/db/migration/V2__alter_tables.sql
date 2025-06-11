ALTER TABLE genero
ADD COLUMN data_criacao TIMESTAMP,
ADD COLUMN data_atualizacao TIMESTAMP;

ALTER TABLE filme
ADD COLUMN data_criacao TIMESTAMP,
ADD COLUMN data_atualizacao TIMESTAMP;

ALTER TABLE avaliacao
ADD COLUMN data_criacao TIMESTAMP,
ADD COLUMN data_atualizacao TIMESTAMP;


