INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Semente Alface', 'Descrição de Semente de alface', 30.50, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Semente de Tomate', 'Drescição da Semente de Tomate', 120.00, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Semente de Cebola', 'Drescrição de Semente de Cebola', 55.00, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Semente de Batata', 'Descrição de Batata', 300.00, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Adubo Orgânico', 'Descrição do Adubo Orgânico', 30.50, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Fertilizante Químico', 'Drescição do Fertilizante Químico', 45.75, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Herbicida', 'Descrição do Herbicida', 85.90, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Inseticida', 'Drescrição do Inseticida', 60.00, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Pesticida', 'Drescrição do Pesticida', 70.50, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Pesticida', 'Drescrição do Pesticida', 70.50, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Pesticida', 'Drescrição do Pesticida', 70.50, 1000, '2025-10-17', 'INSUMO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Alface', 'Descrição de alface', 130.50, 100, '2025-12-17', 'PRODUTO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Tomate', 'Drescição da Tomate', 180.00, 100, '2025-12-17', 'PRODUTO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Cebola', 'Drescrição de Cebola', 155.00, 100, '2025-12-17', 'PRODUTO');
INSERT INTO tb_insumo(nome, descricao, valor_unitario, quantidade_estoque, data_validade, categoria) VALUES ('Batata', 'Descrição de Batata', 500.00, 100, '2025-12-17', 'PRODUTO');

INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Milho Safra', '2024-01-01', 90, 'PLANTIO', 100);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Soja Safra', '2024-02-01', 60, 'PLANTIO', 150);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Trigo Safra', '2024-03-01', 30, 'PLANTIO', 200);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Arroz Safra', '2024-04-01', 15, 'PLANTIO', 200);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Café Safra', '2024-05-01', 30, 'PLANTIO', 1500);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Feijão Safra', '2024-06-01', 60, 'PLANTIO', 150);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Cana-de-açúcar Safra', '2024-07-01', 160, 'PLANTIO', 220);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Batata Safra', '2024-08-01', 60, 'PLANTIO',200);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Tomate Safra', '2024-09-01', 45, 'PLANTIO', 200);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Alface Safra', '2024-10-01', 30, 'PLANTIO', 200);


INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (1, 1, 50);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (2, 1, 100);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (3, 3, 200);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (4, 1, 150);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (5, 5, 120);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (6, 6, 180);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (7, 7, 90);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (8, 8, 220);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (9, 9, 140);
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade) VALUES (10, 10, 130);
