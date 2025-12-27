# Lista de Requisitos - Projeto Mamãe Contente
**Versão:** 1.0  
**Status:** Em Aprovação  
**Última Atualização:** 27/12/2025  

## 1. Visão Geral
O sistema tem como objetivo gerenciar o estoque de itens para venda (Bazar) para arrecadação de fundos, bem como gerenciar o recebimento de doações, cadastro de mães beneficiárias e a montagem de kits para distribuição.

## 2. Requisitos Funcionais (RF)

| ID | Módulo | Descrição do Requisito | Prioridade |
| :--- | :--- | :--- | :--- |
| **RF001** | **Autenticação** | O sistema deve permitir o login de voluntários/administradores via e-mail e senha. | Alta |
| **RF002** | **Bazar** | O sistema deve permitir o cadastro de itens de artesanato (CRUD), contendo: Nome, Foto, Categoria, Preço e Quantidade. | Alta |
| **RF003** | **Bazar** | O sistema deve permitir visualizar a listagem de itens do bazar com seus respectivos preços. | Alta |
| **RF004** | **Doação** | O sistema deve permitir o cadastro de itens recebidos para doação (CRUD), contendo: Nome, Foto, Categoria, Tamanho, Gênero (M/F/U) e Quantidade. *Nota: Não possui preço.* | Alta |
| **RF005** | **Doação** | O sistema deve permitir filtrar o estoque de doações por categoria (ex: Fraldas, Roupas) e tamanho (ex: RN, P, M). | Média |
| **RF006** | **Beneficiários** | O sistema deve permitir o cadastro de mães beneficiárias, contendo: Nome, Endereço, Contato e **Data Prevista do Parto/Idade do Bebê**. | Alta |
| **RF007** | **Kits** | O sistema deve permitir a criação de um "Kit de Doação" vinculado a uma mãe beneficiária específica. | Média |
| **RF008** | **Kits** | O sistema deve permitir adicionar itens do estoque de doações para dentro de um Kit, validando a disponibilidade da quantidade. | Média |
| **RF009** | **Kits** | Ao finalizar/entregar um Kit, o sistema deve dar baixa automaticamente na quantidade dos itens no estoque de doações. | Alta |
| **RF010** | **Relatórios** | O sistema deve apresentar um dashboard simples na tela inicial com atalhos para os módulos e resumo de pendências. | Baixa |

## 3. Requisitos Não Funcionais (RNF)

| ID | Categoria | Descrição do Requisito | Prioridade |
| :--- | :--- | :--- | :--- |
| **RNF001** | **Usabilidade** | A interface móvel deve priorizar elementos grandes e de fácil toque, seguindo as cores da identidade visual (tons terrosos/pastel). | Alta |
| **RNF002** | **Desempenho** | A listagem de produtos (com imagens) deve utilizar paginação ou "lazy loading" para não consumir dados excessivos do usuário. | Média |
| **RNF003** | **Plataforma** | O aplicativo móvel (Front-end) deve ser desenvolvido em **Kotlin** (Android Nativo/Compose) suportando Android 8.0+. | Alta |
| **RNF004** | **Arquitetura** | O Back-end deve ser desenvolvido em **Java (Spring Boot)**, estruturado preferencialmente como Monólito Modular. | Alta |
| **RNF005** | **Persistência** | Os dados devem ser armazenados em banco relacional **PostgreSQL**. | Alta |
| **RNF006** | **Segurança** | As senhas dos usuários devem ser armazenadas com hash (ex: BCrypt), nunca em texto plano. | Alta |
| **RNF007** | **Conectividade** | O aplicativo requer conexão com a internet para sincronizar dados (operação online-first). | Média |

## 4. Glossário do Domínio

* **Bazar:** Setor responsável pela venda de produtos para arrecadar fundos.
* **Doação (Estoque):** Itens recebidos que **não** possuem valor comercial e serão repassados gratuitamente.
* **Kit:** Conjunto agrupado de itens de doação destinado a uma única mãe/bebê.