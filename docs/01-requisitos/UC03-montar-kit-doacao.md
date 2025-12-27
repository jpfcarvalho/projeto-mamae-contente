# Caso de Uso 03: Montar e Entregar Kit

**Ator Principal:** Voluntário  
**Módulo:** Kits / Doação  
**Requisitos Associados:** RF007, RF008, RF009  

## 1. Descrição
Este é o processo core da ONG. Consiste em selecionar uma mãe beneficiária e agrupar diversos itens de doação em um "Kit" para entrega.

## 2. Pré-condições
* Existir itens no "Estoque de Doações".
* A mãe beneficiária já deve estar cadastrada (UC04).

## 3. Fluxo Principal
1. O voluntário acessa "Montar Kit".
2. O sistema solicita a seleção da Beneficiária.
3. O sistema exibe os dados da mãe (ex: "Maria, Bebê Menino, 3 meses") para auxiliar na escolha.
4. O voluntário acessa o catálogo de doações.
5. O voluntário seleciona itens (ex: 10 Fraldas M, 2 Bodies P) e adiciona ao Kit.
6. O sistema decremente visualmente a disponibilidade enquanto os itens estão no "carrinho" do kit.
7. O voluntário revisa o Kit e clica em "Finalizar/Entregar".
8. O sistema realiza a **baixa definitiva** no estoque.
9. O sistema gera um registro de histórico ("A mãe Maria recebeu o Kit #405 na data X").

## 4. Fluxos de Exceção
**4a. Estoque Insuficiente**
* Se no passo 5 o voluntário tentar adicionar 5 itens, mas só houver 3 no estoque físico, o sistema bloqueia e alerta "Quantidade indisponível".

## 5. Pós-condições
* Estoque de doações atualizado.
* Histórico da beneficiária atualizado.