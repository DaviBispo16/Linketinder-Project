### Nome: Davi Bispo Pereira Cruz

# Projeto Groovy (Cadastro de Empresas / Candidatos)

Projeto completo contendo backend em **Groovy** e frontend em **TypeScript** / **HTML** para cadastro e listagem de empresas e candidatos. O backend utiliza JDBC/PostgreSQL para persistência de dados.

---

## 🛠️ Requisitos

- **Java (JDK) 11+**
- **PostgreSQL** instalado/criado e rodando
- **Node.js** e **Yarn** (para o frontend)
- (Opcional) **Groovy 3+** (para executá-lo diretamente como script)

---

## 🗄️ Passo 1: Configuração do Banco de Dados (PostgreSQL)

O projeto requer um banco de dados PostgreSQL. Por padrão as seguintes credenciais e informações são utilizadas (podem ser substituídas por variáveis de ambiente):
- **Host:** `localhost`
- **Port:** `5432`
- **User:** `postgres`
- **Password:** `linketinder`
- **Database:** `linketinder`



## ⚙️ Passo 2: Como Executar o Backend (Groovy)

Existem duas formas principais de iniciar o Backend: utilizando **Gradle** (Recomendado) ou como **Script**.

### Opção A: Executar usando Gradle Wrapper (Recomendado)

O projeto usa Gradle e contém todas as dependências necessárias automaticamente configuradas.

1. Para rodar a aplicação no terminal de forma interativa:
   ```bash
   ./gradlew run
   ```
   *No Windows, utilize: `gradlew.bat run`*

2. Para rodar os testes unitários (jUnit/Mockito):
   ```bash
   ./gradlew test
   ```

---

## 🖥️ Passo 3: Como Executar o Frontend (TypeScript)

O frontend localiza-se na pasta `frontend` e é construído com TypeScript.

1. Acesse o diretório do frontend:
   ```bash
   cd frontend
   ```
2. Instale as dependências:
   ```bash
   yarn install
   ```
3. Compile o código TypeScript para JavaScript (isso irá gerar os arquivos convertidos na pasta \`dist\` configurada no tsconfig):
   ```bash
   yarn tsc
   ```

---

## 📊 Modelagem do banco (MER/DER)

<img width="1311" height="752" alt="Screenshot From 2026-04-01 21-45-36" src="https://github.com/user-attachments/assets/f2fea4e0-d6c9-4971-9e38-8416db372d9a" />
Programa utilizado dbDiagram
