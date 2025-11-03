# FinTech---FIAP
API REST desenvolvida em **Spring Boot** para gerenciamento financeiro pessoal, permitindo cadastrar e controlar usuários, receitas e despesas, com conexão ao banco **Oracle** e arquitetura **MVC**.



# 💰 Gestão Financeira API

API desenvolvida em **Spring Boot** para gerenciamento financeiro pessoal.  
O sistema permite cadastrar **usuários, receitas e despesas**, facilitando o controle de ganhos e gastos.

---

## 🚀 Tecnologias Utilizadas
- Java 21  
- Spring Boot  
- Spring Data JPA   
- Oracle Database  
- Maven  
---

src/main/java/br/com/fiap/gestaofinanceira
├── controller # Controladores REST
│ ├── DespesaController
│ ├── ReceitaController
│ └── UsuarioController
│
├── model # Entidades do banco de dados
│ ├── Despesa
│ ├── Receita
│ └── Usuario
│
├── repository # Interfaces de acesso ao banco (JPA)
│ ├── DespesaRepository
│ ├── ReceitaRepository
│ └── UsuarioRepository
│
├── service # Regras de negócio
│ ├── DespesaService
│ ├── ReceitaService
│ └── UsuarioService
│
└── GestaofinanceiraApplication.java # Classe principal do projeto





## ⚙️ Funcionalidades
- ✅ Cadastro de usuário com senha criptografada
- 🔐 Login com autenticação JWT
- 💵 Cadastro e listagem de receitas
- 💳 Cadastro e listagem de despesas
- 🔗 Associação automática das receitas/despesas ao usuário logado

## 🧪 Testes via Insomnia
Endpoints disponíveis:

### 👤 Usuário
- `POST /api/usuarios` → Cadastra um novo usuário  
- `POST /api/login` → Realiza login e retorna token JWT

### 💰 Receitas
- `POST /api/receitas` → Cadastra uma receita (autenticado)
- `GET /api/receitas` → Lista receitas do usuário autenticado

### 💸 Despesas
- `POST /api/despesas` → Cadastra uma despesa (autenticado)
- `GET /api/despesas` → Lista despesas do usuário autenticado

---

## 🧩 Como Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/FinTech.git
Configure o banco de dados em application.properties

