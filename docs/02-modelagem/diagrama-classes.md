# Diagrama de Classes de Domínio
**Projeto:** Mamãe Contente  
**Linguagem:** Java / Kotlin  
**Padrão:** Domain-Driven Design

## 1. Visão Geral
Este diagrama representa as **Entidades de Domínio**. Evitando acoplamento direto entre os módulos de *Bazar* e *Doação*.

## 2. Diagrama

```mermaid
classDiagram
    %% --- PACOTE CORE / SEGURANÇA ---
    namespace Core {
        class Usuario {
            -Long id
            -String nome
            -String email
            -String senhaHash
            -PerfilAcesso perfil
            +autenticar(String senha) boolean
            +alterarSenha(String novaSenha) void
        }

        class PerfilAcesso {
            <<enumeration>>
            ADMIN
            VOLUNTARIO
        }
    }

    %% --- PACOTE BAZAR (VENDAS) ---
    namespace Modulo_Bazar {
        class ProdutoArtesanato {
            -Long id
            -String nome
            -BigDecimal preco
            -int quantidadeEstoque
            +atualizarEstoque(int qtd) void
            +verificarDisponibilidade(int qtd) boolean
        }

        class EventoBazar {
            -Long id
            -String nome
            -LocalDateTime inicio
            -LocalDateTime fim
            -StatusEvento status
            +abrirEvento() void
            +fecharEvento() void
            +calcularTotalVendido() BigDecimal
        }

        class Venda {
            -Long id
            -LocalDateTime dataHora
            -BigDecimal valorTotal
            -FormaPagamento pagamento
            +adicionarItem(ProdutoArtesanato prod, int qtd) void
            +finalizarVenda() void
            -calcularTotal() void
        }

        class ItemVenda {
            -int quantidade
            -BigDecimal precoPraticado
            +calcularSubtotal() BigDecimal
        }
    }

    %% --- PACOTE DOAÇÃO (SOCIAL) ---
    namespace Modulo_Doacao {
        class ItemDoacao {
            -Long id
            -String nome
            -Tamanho tamanho
            -Genero genero
            -int quantidadeEstoque
            +baixarEstoque(int qtd) void
        }

        class Beneficiaria {
            -Long id
            -String nome
            -LocalDate dataReferencia
            +calcularIdadeBebe() String
            +sugerirTamanhoRoupa() Tamanho
        }

        class KitDoacao {
            -Long id
            -String codigo
            -LocalDateTime dataEntrega
            -StatusKit status
            +adicionarItem(ItemDoacao item, int qtd) void
            +entregarKit() void
        }

        class ItemKit {
            -int quantidade
            +validarDisponibilidade() boolean
        }

        class Tamanho {
            <<enumeration>>
            RN
            P
            M
            G
            ANO_1
        }
    }

    %% --- RELACIONAMENTOS (Definidos Fora dos Namespaces para evitar erros) ---

    %% Relações Bazar
    EventoBazar "1" *-- "*" Venda : contem
    Venda "1" *-- "*" ItemVenda : possui
    ItemVenda --> ProdutoArtesanato : referencia

    %% Relações Doação
    Beneficiaria "1" <-- "*" KitDoacao : recebe
    KitDoacao "1" *-- "*" ItemKit : composto_por
    ItemKit --> ItemDoacao : retira_de

    %% Relações Entre Pacotes
    Usuario ..> EventoBazar : gerencia
    Usuario ..> KitDoacao : monta