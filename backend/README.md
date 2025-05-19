# 🎬 Avaliador de Filmes - API REST com Spring Boot

Sistema para cadastro de usuários, filmes, avaliações e gerenciamento de gêneros com controle de acesso via autenticação JWT.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Flyway (migrations)
- Swagger (OpenAPI 3)
- Docker (para banco de dados)
- BCrypt para criptografia de senha

---

## ⚙️ Funcionalidades principais

### 👤 Usuários
- Cadastro de usuário com `tipoUsuario` (`USER` ou `ADMIN`)
- Login com email e senha
- Geração de token JWT

### 🎥 Filmes
- `GET /filmes` – Todos os usuários podem visualizar
- `POST /filmes` – Apenas `ADMIN`
- `DELETE /filmes/{id}` – Apenas `ADMIN`

### 🎭 Gêneros
- `GET /generos` – Todos podem visualizar
- `POST /generos` – Apenas `ADMIN`
- `DELETE /generos/{id}` – Apenas `ADMIN`

### 🌟 Avaliações
- `POST /avaliacoes` – Apenas `USER` pode avaliar filmes
- `GET /avaliacoes` – Apenas `ADMIN` pode ver todas

---

## 🔐 Perfis de Usuário

| Permissão        | USER | ADMIN |
|------------------|------|-------|
| Ver filmes       | ✅   | ✅    |
| Avaliar filmes   | ✅   | ✅    |
| Cadastrar filmes | ❌   | ✅    |
| Cadastrar gêneros| ❌   | ✅    |
| Ver avaliações   | ❌   | ✅    |

---

## 📦 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/avaliador-filmes.git
cd avaliador-filmes
BOSCOV
