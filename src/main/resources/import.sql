INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Pesticida', 70.50, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Semente Alface', 30.50, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Semente de Tomate', 120.00, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Semente de Cebola', 55.00, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Semente de Batata', 300.00, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Adubo Orgânico', 30.50, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Fertilizante Químico', 45.75, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Herbicida', 85.90, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Inseticida', 60.00, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Pesticida', 70.50, 1000, '2025-10-17');
INSERT INTO tb_insumo(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Pesticida', 70.50, 1000, '2025-10-17');

INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-01-01', 90, 'PLANTIO', 100);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-02-01', 60, 'PLANTIO', 150);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-03-01', 30, 'PLANTIO', 200);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-04-01', 15, 'PLANTIO', 200);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-05-01', 30, 'PLANTIO', 1500);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-06-01', 60, 'PLANTIO', 150);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-07-01', 160, 'PLANTIO', 220);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-08-01', 60, 'PLANTIO',200);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-09-01', 45, 'PLANTIO', 200);
INSERT INTO tb_producao(data_entrada, tempo_plantio, status_producao, quantidade_prevista) VALUES ('2024-10-01', 30, 'PLANTIO', 200);


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

INSERT INTO tb_produto(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Alface', 3.00, 100, '2025-10-17')
INSERT INTO tb_produto(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Tomate', 6.00, 100, '2025-10-17')
INSERT INTO tb_produto(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Cebola', 4.00, 100, '2025-10-17')
INSERT INTO tb_produto(nome, valor_unitario, quantidade_estoque, data_validade) VALUES ('Batata', 8.00, 100, '2025-10-17')

INSERT INTO tb_user (name, email, password) VALUES ('Alex', 'alex@gmail.com', '$2a$10$Omml9pexRdPud66HtbyBc.NuR2PGooZG0qYjqbeUc7ZYNiVithN22')
INSERT INTO tb_user (name, email, password) VALUES ('Maria', 'maria@gmail.com', '$2a$10$Omml9pexRdPud66HtbyBc.NuR2PGooZG0qYjqbeUc7ZYNiVithN22')
INSERT INTO tb_user (name, email, password) VALUES ('Renan', '1', '$2a$10$/msoDTHSgK25oN9PPIggC.meyQ6QJbvLvBUs/wq3O9AuXwrsCptM6')

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR')
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN')

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2)
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2)
