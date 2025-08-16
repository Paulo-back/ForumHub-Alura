
# Challenge Forum Hub

## 📱 Descrição
Neste desafio de programação, fui convidado a construir um Forum que seus usuarios podem criar tópicos de duvidas,responder estes tópicos,criação de usuário,cursos dos tópicos, tendo seus respectivos crud's.

## 🎯 Objetivo
Desenvolver o back end de um fórum interativo, o FórumHub, com uma API REST criada em Spring Boot para gerenciar e relacionar tópicos, respostas e usuários.

## 🚀 Funcionalidades
***Gestão de Tópicos:*** 
- Criar Tópico: Permitir que usuários autenticados postem novos tópicos.

- Listar Tópicos: Exibir todos os tópicos existentes, com a opção de filtrar por curso ou status.

- Detalhar Tópico: Visualizar um tópico específico, incluindo todas as suas respostas.

- Atualizar Tópico: Permitir que o autor do tópico (ou um moderador) edite o conteúdo.

- Excluir Tópico: Permitir a remoção de um tópico, garantindo a sua integridade e das respostas relacionadas.

***Interação com Respostas:***

- Responder Tópico: Permitir que usuários postem respostas em tópicos existentes.

- Marcar Resposta como Solução: O autor do tópico pode indicar qual resposta resolveu a sua dúvida.

- Atualizar Resposta: Permitir que o autor da resposta edite o seu conteúdo.

- Excluir Resposta: Permitir a remoção de respostas.

***Gestão de Usuários e Autenticação:***

- Cadastro de Usuário: Novo usuário pode se registrar na plataforma.

- Autenticação de Usuário (Login): Validar credenciais e gerar um token JWT para acesso seguro.

- Autorização por Token (JWT): Proteger endpoints e garantir que apenas usuários com permissões corretas possam acessá-los.

***Funcionalidades Adicionais:***

- Cadastro de Cursos: Permitir que cursos sejam registrados no sistema, servindo como base para a criação dos tópicos.

- Validação de Dados: Garantir que os dados enviados estejam corretos e completos.

## 🛠️ Tecnologias Utilizadas
- IntelliJ IDEA 🤖
- Java ☕
- Spring Boot 🌱
- JPA / Hibernate 🗃️
- FlyWay ✈️
- MySql 🐬
- Maven ⚡


## Produzido por:
#### *Paulo Henrique Rosa*
- [Linkedin](https://www.linkedin.com/in/paulo-henrique-rosa-dev/)
- [Github](https://github.com/Paulo-back)

## 💻 Cursos do Projeto

✅ [Java: persistência de dados e consultas com Spring Data JPA](https://cursos.alura.com.br/course/java-persistencia-dados-consultas-spring-data-jpa)

✅ [Spring Boot 3: desenvolva uma API Rest em Java](https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java)

✅ [Spring Boot 3: aplique boas práticas e proteja uma API Rest](https://cursos.alura.com.br/course/spring-boot-aplique-boas-praticas-proteja-api-rest)

## Instalação e uso:
## ▶ Como rodar
```bash
# Clone o repositório
git clone https://github.com/Paulo-back/ForumHub-Alura.git

# Entre na pasta
cd ForumHub

# Configure o banco de dados(mysql) em src/main/resources/application.properties
# Configure as variáveis de ambiente do application.properties


# Rode a aplicação
mvn spring-boot:run

# Links ou portas
Acesse a aplicação em: http://localhost:8080

```
## 🌐 Endpoints

### 👤 Usuários
| Método | Rota           | Descrição           |
|--------|----------------|-------------------|
| POST   | /usuarios/cadastro      | Cadastrar usuário |
| GET    | /usuarios/listar      | Listar usuários   |
| DELETE | /delete/{id} | Deletar usuário   |

### 📝 Tópicos
| Método | Rota           | Descrição         |
|--------|----------------|-----------------|
| POST   | /topicos/cadastro       | Cadastrar tópico |
| GET    | /topicos/listar       | Listar tópicos   |
| GET    | /topicos/listar/{id}       | Listar tópico por id   |
| PUT    | /topicos/topicos/editar/{id}  | Atualizar tópico |
| DELETE | /topicos/delete/{id}  | Deletar tópico   |

### 💬 Respostas
| Método | Rota            | Descrição            |
|--------|-----------------|--------------------|
| POST   | /respostas/cadastrar      | Cadastrar resposta |
| GET    | /respostas/listar      | Listar respostas   |
| GET    | /respostas/listar/{id} | Atualizar resposta |
| DELETE | /respostas/delete/{id} | Deletar resposta   |

### 🎓 Cursos
| Método | Rota          | Descrição         |
|--------|---------------|-----------------|
| POST   | /cursos/cadastro       | Cadastrar curso |
| GET    | /cursos/listar       | Listar cursos   |
| GET    | /cursos/listar/{id}  | Listar curso por id |
| DELETE | /cursos/delete/{id}  | Deletar curso   |


