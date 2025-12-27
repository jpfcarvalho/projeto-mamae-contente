# Caso de Uso 02: Manter Item de Doação

**Ator Principal:** Voluntário  
**Módulo:** Doação  
**Requisitos Associados:** RF004, RF005  

## 1. Descrição
Permite cadastrar itens recebidos (roupas, fraldas, brinquedos) que serão destinados gratuitamente às mães. A ênfase é na triagem por tamanho e gênero.

## 2. Pré-condições
* O usuário deve estar logado.

## 3. Fluxo Principal
1. O voluntário acessa a opção "Estoque Doações".
2. O sistema exibe a lista filtrada por padrão (ex: Todos).
3. O voluntário clica em "Adicionar".
4. O sistema solicita os dados de triagem:
   * Nome do Item (ex: Body Manga Longa)
   * Categoria (ex: Roupa)
   * **Tamanho** (ex: RN, P, M, G)
   * **Gênero** (Masculino, Feminino, Unissex)
   * Quantidade
5. O voluntário salva o registro.
6. O sistema grava o item no estoque de doações **sem valor financeiro**.

## 4. Regras de Negócio
* **RN01:** Diferente do Bazar, o campo "Preço" não deve existir ou deve ser gravado como 0.00 internamente.
* **RN02:** O campo "Tamanho" é obrigatório para a categoria "Roupas".

## 5. Pós-condições
* O item fica disponível para ser vinculado a um Kit de Doação.