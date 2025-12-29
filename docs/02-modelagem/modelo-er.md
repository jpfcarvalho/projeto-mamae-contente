# Modelo de Entidade Relacionamento (MER)
**Projeto:** Mamãe Contente  
**Banco de Dados:** PostgreSQL  
**Versão:** 1.0

## 1. Diagrama ER

```mermaid
erDiagram

    usuario {
        bigint id PK
        varchar nome
        varchar email UK
        varchar senha_hash
        varchar perfil
    }
    
    produto_artesanato {
        bigint id PK
        varchar nome
        text descricao
        varchar categoria
        decimal preco
        int quantidade_estoque
        varchar url_foto
    }

    evento_bazar {
        bigint id PK
        varchar nome
        timestamp data_inicio
        timestamp data_fim
        varchar local
        varchar status "AGENDADO, OCORRENDO, FINALIZADO"
    }

    venda {
        bigint id PK
        timestamp data_hora
        decimal valor_total
        varchar forma_pagamento "PIX, DINHEIRO, CARTAO"
        bigint evento_id FK
    }

    item_venda {
        bigint id PK
        bigint venda_id FK
        bigint produto_artesanato_id FK
        int quantidade_vendida
        decimal preco_praticado
    }

    item_doacao {
        bigint id PK
        varchar nome
        varchar categoria
        varchar tamanho "RN, P, M, G"
        varchar genero "M, F, U"
        int quantidade_estoque
        varchar url_foto
    }

    beneficiaria {
        bigint id PK
        varchar nome
        varchar telefone
        date data_referencia
        timestamp data_cadastro
    }

    kit_doacao {
        bigint id PK
        varchar codigo_identificador
        timestamp data_criacao
        timestamp data_entrega
        varchar status "EM_MONTAGEM, ENTREGUE"
        bigint beneficiaria_id FK
    }

    item_kit {
        bigint id PK
        bigint kit_id FK
        bigint item_doacao_id FK
        int quantidade
    }

    evento_bazar ||--o{ venda : gera
    venda ||--|{ item_venda : contem
    produto_artesanato ||--o{ item_venda : vendido_em

    beneficiaria ||--o{ kit_doacao : recebe
    kit_doacao ||--|{ item_kit : contem
    item_doacao ||--o{ item_kit : compoe