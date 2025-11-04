# Projeto Fintech - Challenge FIAP

Projeto full-stack (Java/Spring, Oracle, React) para controle de finanças pessoais.

## Integrantes do Grupo

* Nome - RM
* Nome - RM
* Nome - RM

Instruções de Inicialização

### Pré-requisitos

* Java JDK 21
* Node.js (v18 ou superior)
* Acesso à instância Oracle da FIAP

1. Backend (Spring Boot)

1.  Abra um terminal e navegue até a pasta `backend`:
    ```bash
    cd backend
    ```
2.  **Importante:** Configure seu RM e senha do Oracle no arquivo:
    `backend/src/main/resources/application.properties`

3.  Execute o servidor Spring:
    ```bash
    ./mvnw spring-boot:run
    ```
4.  O servidor estará rodando em `http://localhost:8080`.

### 2. Frontend (React)

1.  Abra um **segundo terminal** e navegue até a pasta `frontend`:
    ```bash
    cd frontend
    ```
2.  Instale as dependências:
    ```bash
    npm install
    ```
3.  Inicie o servidor React:
    ```bash
    npm start
    ```
4.  A aplicação estará disponível em `http://localhost:3000`.

## 🔑 Dados de Autenticação (Teste)

Para acessar o sistema, cadastre um novo usuário primeiro (via API ou implementando a tela) e depois use as credenciais na página de login.

* **Login:** (email do usuário cadastrado)
* **Senha:** (senha do usuário cadastrado)