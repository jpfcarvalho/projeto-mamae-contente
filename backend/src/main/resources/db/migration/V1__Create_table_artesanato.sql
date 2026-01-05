CREATE TABLE artesanato (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco NUMERIC(19, 2) NOT NULL,
    quantidade INTEGER,
    url_imagem VARCHAR(255)
);
