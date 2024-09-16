INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Adubo Orgânico', 30.50);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Semente de Milho', 120.00);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Fertilizante Químico', 45.75);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Herbicida', 85.90);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Inseticida', 60.00);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Pesticida', 70.50);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Semente de Trigo', 150.00);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Irrigação por Gotejamento', 300.00);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Calcário', 55.00);
INSERT INTO tb_insumo(nome, valor_unitario) VALUES ('Semente de Soja', 180.00);

INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Milho Safra', '2024-01-01', 90, 'PLANTIO', 100);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Soja Safra', '2024-02-01', 120, 'PLANTIO', 150);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Trigo Safra', '2024-03-01', 100, 'EM_CRESCIMENTO', 200);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Arroz Safra', '2024-04-01', 80, 'PRONTO_PARA_COLHEITA', 200);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Café Safra', '2024-05-01', 150, 'PLANTIO', 1500);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Feijão Safra', '2024-06-01', 110, 'EM_CRESCIMENTO', 150);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Cana-de-açúcar Safra', '2024-07-01', 160, 'PRONTO_PARA_COLHEITA', 220);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Batata Safra', '2024-08-01', 70, 'COLHIDO',130);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Tomate Safra', '2024-09-01', 60, 'FINALIZADO', 210);
INSERT INTO tb_producao(nome_producao, data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('Alface Safra', '2024-10-01', 30, 'PLANTIO', 100);

INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (1, 1, 50, '2024-01-15');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (2, 1, 100, '2024-02-10');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (3, 3, 200, '2024-03-05');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (4, 1, 150, '2024-04-01');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (5, 5, 120, '2024-05-20');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (6, 6, 180, '2024-06-18');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (7, 7, 90, '2024-07-15');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (8, 8, 220, '2024-08-10');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (9, 9, 140, '2024-09-05');
INSERT INTO tb_insumo_producao(insumo_id, producao_id, quantidade, data_saida) VALUES (10, 10, 130, '2024-10-02');

INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (2, 90, 10, 'BOM', 'DOENCAS');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (1, 100, 5, 'EXCELENTE', 'PRAGAS');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (3, 80, 20, 'REGULAR', 'CLIMA');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (4, 95, 5, 'BOM', 'ERRO_HUMANO');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (5, 70, 30, 'RUIM', 'OUTRO');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (6, 85, 15, 'EXCELENTE', 'DOENCAS');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (7, 50, 50, 'PERDA_TOTAL', 'CLIMA');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (8, 60, 40, 'REGULAR', 'PRAGAS');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (9, 120, 10, 'EXCELENTE', 'ERRO_HUMANO');
INSERT INTO tb_colheita(producao_id, quantidade_colhida, quantidade_perdida, resultado_colheita, tipo_perda) VALUES (10, 110, 20, 'BOM', 'OUTRO');
