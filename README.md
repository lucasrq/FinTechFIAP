# Projeto Fintech

Projeto full-stack para gerenciamento financeiro pessoal, desenvolvido com Spring Boot, Java, Oracle e React, como parte da avaliação da FIAP.

## Integrantes do Grupo

* Christian Ferreira Bernardi - RM562070
* Lucas Rodrigues Roque Da Silva - RM562918
* Matheus Souza Santos - RM565070
* Beatriz Maria Alves de Carvalho - RM565657

---

## 🚀 Conceito do Projeto

A aplicação é uma API RESTful de gestão financeira que permite aos usuários cadastrar, controlar e visualizar suas receitas e despesas. A aplicação é construída em uma arquitetura desacoplada (backend e frontend) e implementa o CRUD completo para as 3 entidades principais: `Usuario`, `Receita` e `Despesa`.

## 🛠️ Tecnologias Utilizadas

* **Backend:** Java 21, Spring Boot 3, Spring Data JPA, Maven
* **Frontend:** ReactJS, React Router, Axios, CSS Puro
* **Banco de Dados:** Oracle (Perfil Obrigatório) e H2 Database (Perfil de Teste)

---

## ⚙️ Instruções de Inicialização (Obrigatório)

Este projeto é um "monorepo" contendo dois projetos independentes: `backend` e `frontend`. Você precisará de **dois terminais** abertos para executá-lo.

### 1. Backend (Servidor Spring)

O backend está configurado com **Perfis do Spring** para rodar tanto com o Oracle da FIAP (obrigatório) quanto com um banco H2 100% localhost (alternativo).

#### Opção A: Rodando com Oracle (Padrão Obrigatório)

**AVISO:** No momento da entrega deste projeto (05/11/2025), o servidor Oracle da FIAP (`oracle.fiap.com.br`) estava retornando o erro `ORA-01034: ORACLE not available`, indicando que a instância `ORCL` está offline. O código está configurado conforme solicitado.

1.  **Configure suas credenciais:**
    * Abra o arquivo: `backend/src/main/resources/application-oracle.properties`
    * Insira seu `RM` e `SENHA` da instância Oracle da FIAP.

2.  **Execute o servidor:**
    * Navegue até a pasta `backend` no seu terminal:
        ```bash
        cd backend
        ```
    * (Apenas na primeira vez ou se der erro de permissão no Linux/Mac)
        ```bash
        chmod +x mvnw
        ```
    * Inicie o servidor (ele usará o perfil 'oracle' por padrão):
        ```bash
        ./mvnw spring-boot:run
        ```
3.  O servidor estará em `http://localhost:8080` (se a conexão com Oracle for bem-sucedida).

#### Opção B: Rodando com H2 (Alternativa Localhost para Testes)

Este perfil não requer instalação de banco de dados e roda 100% em memória. **Recomendado para testar a funcionalidade da aplicação.**

1.  **Não é necessário configurar credenciais.**

2.  **Execute o servidor com o perfil "local":**
    * Navegue até a pasta `backend`: `cd backend`
    * Inicie o servidor especificando o perfil:
        ```bash
        ./mvnw spring-boot:run -Dspring.profiles.active=local
        ```
3.  O servidor estará rodando em `http://localhost:8080`.

4.  **(Bônus)** Você pode acessar o console do banco H2 para ver os dados:
    * Acesse: `http://localhost:8080/h2-console`
    * JDBC URL: `jdbc:h2:mem:fintechdb`
    * Clique em "Connect".

### 2. Frontend (Aplicação React)

1.  **Abra um segundo terminal.**
2.  Navegue até a pasta `frontend`: `cd frontend`
3.  **Instale as dependências** (apenas na primeira vez):
    ```bash
    npm install
    ```
4.  **Inicie o servidor React:**
    ```bash
    npm start
    ```
5.  A aplicação será aberta automaticamente no seu navegador em `http://localhost:3000`.

---

## 🔑 Teste de Funcionalidade (100% no Navegador)

Siga estes passos para validar a aplicação (usando a **Opção B: H2 Localhost** do backend).

### 1. Cadastrar Usuário de Teste

1.  Acesse `http://localhost:3000`. Você será automaticamente redirecionado para a página de Login.
2.  Clique no link **"Cadastre-se"**.
3.  Preencha o formulário com os dados do usuário de teste:
    * **Nome:** `Professor Avaliador`
    * **Email:** `professor@fiap.com.br`
    * **Senha:** `123`
4.  Clique em "Cadastrar". Você verá um alerta de sucesso e será enviado de volta para a página de Login.

### 2. Realizar Login

1.  Na página de Login, insira as credenciais que você acabou de criar:
    * **Email:** `professor@fiap.com.br`
    * **Senha:** `123`
2.  Você será redirecionado para a página "Bem-vindo".

### 3. Testar o CRUD de Despesas e Receitas

1.  Na página inicial, clique em "Ver Despesas".
2.  Clique no link "&larr; Voltar ao Menu Principal" para testar a navegação.
3.  Use o formulário para **Adicionar** uma nova despesa (ex: "Aluguel", "1500").
4.  Clique em "Editar" na despesa criada e **Atualize** o valor (ex: para "1550").
5.  Clique em "Excluir" para **Remover** a despesa.
6.  Volte à página inicial e repita o processo completo (Adicionar, Atualizar, Excluir) para a seção "Ver Receitas".

### 4. Testar Rotas Protegidas e Logout

1.  Clique no botão "Sair" na página inicial.
2.  Você será redirecionado para a página de Login.
3.  Tente acessar a rota principal (`http://localhost:3000/`) manualmente no navegador.
4.  A aplicação deve bloquear o acesso e mantê-lo na página de Login, confirmando a segurança das rotas.