# ⚙️ Hackathon Alura ONE | API Backend de Participantes

Este projeto é o **backend** da aplicação de gerenciamento de participantes, desenvolvido como uma API RESTful utilizando **Spring Boot**. Ele é responsável por gerenciar a persistência dos dados, a lógica de negócio e a comunicação com o frontend.

## 💻 Tecnologias

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.x
* **Banco de Dados:** H2 Database (em memória, para desenvolvimento e testes)
* **Construção:** Maven

## ✨ Funcionalidades da API (Endpoints)

A API oferece os seguintes endpoints para gerenciamento dos participantes:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/participantes` | Cadastra um novo participante. |
| `GET` | `/participantes` | Lista todos os participantes (retorna um Pageable). |
| `GET` | `/participantes/{id}` | Busca um participante específico por ID. |
| `DELETE` | `/participantes/{id}` | Exclui um participante da base de dados. |

## 🛠️ Configuração e Execução

### Pré-requisitos

1.  Java Development Kit (JDK) **21** ou superior.
2.  Maven.
3.  Um IDE de sua escolha (IntelliJ IDEA, VS Code com Spring Extensions, Eclipse, etc.).

### Passos para Rodar

1.  **Clone ou Baixe** este repositório.
2.  **Abra o Projeto:** Importe o projeto como um projeto Maven na sua IDE.
3.  **Execute:** Rode a classe principal do Spring Boot (ex: `ParticipantesApplication.java`).

O servidor será iniciado por padrão na porta **8080**.

### 🔗 Configuração do H2 Database

O projeto utiliza o **H2 Database em modo console** para fácil visualização durante o desenvolvimento.

Após iniciar o Spring Boot, você pode acessar o console do H2 em:

* **URL:** `http://localhost:8080/h2-console`
* **Driver:** `org.h2.Driver`
* **JDBC URL:** `jdbc:h2:mem:participantes` (ou o que estiver configurado no `application.properties`)

## 🔑 Variáveis de Ambiente e Propriedades

As configurações do banco de dados e da API estão definidas no arquivo `src/main/resources/application.properties` (ou `application.yml`).

Exemplo de configuração essencial para o H2:

properties
# H2 Database Console
spring.h2.console.enabled=true

# Configuração do banco de dados em memória
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
![hack3](https://github.com/user-attachments/assets/31472fe4-2eb6-4cdd-a998-47543d87d957)

