-- Inserir dados de teste para a tabela Categoria
INSERT INTO categoria (nome) VALUES ('Ensino');
INSERT INTO categoria (nome) VALUES ('Pesquisa');
INSERT INTO categoria (nome) VALUES ('Extensão');
INSERT INTO categoria (nome) VALUES ('Visita Técnica');
INSERT INTO categoria (nome) VALUES ('Aulas Práticas Externas');
INSERT INTO categoria (nome) VALUES ('Aulas de Laboratório');

-- Inserir dados de teste para a tabela Curso
INSERT INTO curso (nome, descricao) VALUES ('Matemática', 'Curso de Matemática');
INSERT INTO curso (nome, descricao) VALUES ('Fisica', 'Curso de Física');

-- Inserir dados de teste para a tabela Atividade
INSERT INTO atividade (nome, data, categoria_id, curso_id, publicada) VALUES ('Atividade 1', '2024-01-01', 1, 1, false);
INSERT INTO atividade (nome, data, categoria_id, curso_id, publicada) VALUES ('Atividade 2', '2024-01-15', 2, 2, true);

-- Inserir dados de teste para a tabela Foto
INSERT INTO foto (url, legenda, atividade_id) VALUES ('http://example.com/foto1.jpg', 'Descrição da Foto 1', 1);
INSERT INTO foto (url, legenda, atividade_id) VALUES ('http://example.com/foto2.jpg', 'Descrição da Foto 2', 2);

-- Inserir dados de teste para a tabela Categoria
INSERT INTO categoria (nome) VALUES ('Ensino');
INSERT INTO categoria (nome) VALUES ('Pesquisa');
INSERT INTO categoria (nome) VALUES ('Extensão');
INSERT INTO categoria (nome) VALUES ('Visita Técnica');
INSERT INTO categoria (nome) VALUES ('Aulas Práticas Externas');
INSERT INTO categoria (nome) VALUES ('Aulas de Laboratório');


