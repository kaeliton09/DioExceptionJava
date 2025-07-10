# Debbugin e Tratamento de Exceções com DIO

Este projeto foi desenvolvido como parte de uma prática proposta pela **Digital Innovation One (DIO)**, com o objetivo de aplicar conceitos de **tratamento de exceções em Java**, incluindo:

- Criação e uso de **exceções personalizadas**
- Uso de blocos `try-catch` para **tratamento de erros**
- Aplicação prática em um sistema de **CRUD de usuários** com interface no console

## 💻 Sobre o Projeto

A aplicação é executada no terminal e permite realizar as operações básicas de um CRUD (Create, Read, Update, Delete) de usuários. Cada usuário possui os seguintes atributos:

- **Nome**
- **E-mail**
- **Data de nascimento**

Durante o uso do sistema, são tratados cenários de erro comuns por meio de exceções, como:

- Dados inválidos ou mal formatados
- Campos obrigatórios não preenchidos
- Acesso a usuários inexistentes
- Outros erros inesperados

O projeto também demonstra como **criar exceções personalizadas** para deixar os tratamentos mais claros e reutilizáveis.

## 🧠 Conceitos aplicados

- Blocos `try`, `catch` e `finally`
- Lançamento de exceções com `throw`
- Criação de classes que estendem `Exception` (exceções personalizadas)
- Validação de entrada de dados no console
- Boas práticas de tratamento de erro em aplicações Java

