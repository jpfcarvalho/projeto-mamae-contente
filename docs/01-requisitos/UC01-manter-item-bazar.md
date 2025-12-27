# Caso de Uso 01: Manter Item do Bazar

**Ator Principal:** Voluntário / Administrador  
**Módulo:** Bazar  
**Requisitos Associados:** RF002, RF003  

## 1. Descrição
Permite ao voluntário cadastrar, editar ou remover itens artesanais que serão vendidos no bazar para arrecadação de fundos.

## 2. Pré-condições
* O usuário deve estar logado no sistema.

## 3. Fluxo Principal (Caminho Feliz)
1. O voluntário acessa a opção "Estoque Bazar" no menu principal.
2. O sistema exibe a lista de itens cadastrados com foto, nome e **preço**.
3. O voluntário seleciona a opção "Adicionar Novo Item".
4. O sistema apresenta o formulário de cadastro.
5. O voluntário preenche: Nome, Categoria, **Preço (R$)**, Quantidade e anexa uma Foto.
6. O voluntário confirma a operação.
7. O sistema valida os dados (verificando se preço > 0).
8. O sistema salva o item e exibe a mensagem "Item cadastrado com sucesso".

## 4. Fluxos Alternativos
**4a. Campos Obrigatórios não preenchidos**
* No passo 7, se o voluntário não preencher o Preço ou Nome, o sistema exibe alerta "Campos obrigatórios ausentes" e mantém os dados na tela para correção.

**4b. Editar Item**
* No passo 3, o voluntário clica sobre um item existente.
* O sistema carrega os dados atuais.
* O voluntário altera o preço ou quantidade e salva.

## 5. Pós-condições
* O item estará visível na listagem de vendas e contabilizado no valor total de estoque do bazar.