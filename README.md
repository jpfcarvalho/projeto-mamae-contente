
# Projeto Mamãe Contente

![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)
![Backend](https://img.shields.io/badge/Backend-Java_Spring_Boot-green)
![Mobile](https://img.shields.io/badge/Mobile-Kotlin_Compose-blue)
![Database](https://img.shields.io/badge/Database-PostgreSQL-blueviolet)

> **Engenharia de Software aplicada ao impacto social.** > Sistema de gestão de estoque, vendas de bazar beneficente e triagem de doações para gestantes e bebês.

---

## Sobre o Projeto
O **Projeto Mamãe Contente** é uma iniciativa sem fins lucrativos. Este software tem como objetivo modernizar e organizar os processos internos da ONG, que atualmente opera manualmente.

O sistema é dividido em dois grandes contextos (Bounded Contexts):
1.  **Módulo Bazar:** Gestão de itens artesanais confeccionados para venda, controle de eventos e fluxo de caixa para arrecadação de fundos.
2.  **Módulo Doação:** Recebimento, triagem (por tamanho/gênero) e montagem de kits de enxoval para distribuição gratuita a mães em situação de vulnerabilidade.

---

## Arquitetura e Engenharia

O projeto segue a filosofia **Docs as Code** e utiliza práticas modernas de desenvolvimento:

* **Arquitetura:** Monólito Modular (Modular Monolith). Os domínios de *Bazar* e *Doação* são logicamente separados para permitir futuro desacoplamento.
* **Mobile:** Arquitetura MVVM (Model-View-ViewModel) com Unidirectional Data Flow (UDF) e UI declarativa.
* **Backend:** Design orientado a domínio (DDD Simplificado) e APIs RESTful.
* **DevOps:** Uso de Docker para orquestração do banco de dados local.

### Tech Stack

| Camada | Tecnologia | Detalhes |
| :--- | :--- | :--- |
| **Mobile (Front)** | **Kotlin** | Jetpack Compose, Coroutines, Retrofit |
| **Backend (API)** | **Java 21** | Spring Boot 3, Spring Data JPA, Validation |
| **Banco de Dados** | **PostgreSQL** | Relacional, rodando via Docker Compose |
| **Design** | **Figma** | Atomic Design, Prototipagem Alta Fidelidade |
| **Documentação** | **Markdown + Mermaid** | Diagramas como código (UML, ER) |

---

## Estrutura do Repositório (Monorepo)

```text
projeto-mamae-contente/
├── .github/             # CI/CD e Templates
├── backend/             # Código fonte da API (Spring Boot)
├── mobile/              # Código fonte do App (Android Studio)
├── docs/                # Documentação de Engenharia (Acesse aqui!)
│   ├── 01-requisitos/   # RFs, RNFs e Casos de Uso
│   ├── 02-modelagem/    # Diagramas de Classe, MER e Arquitetura
│   ├── 03-design/       # UI/UX e Componentes
│   └── 03-prototipos/   # Snapshots e Link do Figma
└── docker-compose.yml   # Orquestração do PostgreSQL

```

---

## Documentação Oficial

A documentação completa de engenharia encontra-se na pasta `/docs`.

Abaixo, os atalhos para os artefatos principais:

* **[Lista de Requisitos](https://www.google.com/search?q=./docs/01-requisitos/lista-de-requisitos.md)** (Funcionais e Não Funcionais)
* **[Modelo de Dados (MER)](https://www.google.com/search?q=./docs/02-modelagem/modelo-er.md)** (Estrutura do PostgreSQL)
* **[Diagrama de Classes](https://www.google.com/search?q=./docs/02-modelagem/diagrama-classes.md)** (Estrutura de Domínio Java)
* **[Protótipos UI](https://www.google.com/search?q=./docs/03-prototipos/README.md)** (Telas e Figma)

---

## Como Rodar Localmente

### Pré-requisitos

* Java JDK 21+
* Android Studio (Koala ou superior)
* Docker & Docker Compose

### Passo 1: Subir o Banco de Dados

```bash
# Na raiz do projeto
docker-compose up -d

```

### Passo 2: Backend

1. Abra a pasta `backend` no IntelliJ IDEA ou VS Code.
2. Execute a classe `MamaeContenteApplication.java`.
3. A API estará disponível em `http://localhost:8080`.

### Passo 3: Mobile

1. Abra a pasta `mobile` no Android Studio.
2. Sincronize o Gradle.
3. Selecione um Emulador e execute (Shift + F10).

---

**Desenvolvido por João Carvalho**