📦 CP02 - API 1 (Spring Boot)

API desenvolvida em Spring Boot para gerenciamento de dados relacionados a Brasil e Japão, utilizando MySQL como banco de dados.

🚀 Tecnologias Utilizadas
Java 17+
Spring Boot
Spring Data JPA
Maven
MySQL
Docker
Swagger (Springdoc)
📁 Estrutura do Projeto

.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── cp02/cp02_api1_EnzoWakao/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       └── repository/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
└── README.md

⚙️ Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

Java 17 ou superior
Maven (ou usar o mvnw)
Docker
🐳 Subindo o banco de dados com Docker

O projeto está configurado para usar MySQL, conforme o application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/api
spring.datasource.username=root
spring.datasource.password=root_pwd
🔹 Comando para subir o MySQL
docker run -d \
  --name mysql-api \
  -e MYSQL_ROOT_PASSWORD=root_pwd \
  -e MYSQL_DATABASE=api \
  -p 3306:3306 \
  mysql:8
🔌 Como acessar o banco de dados
✔️ Via cliente (DBeaver, Workbench, etc.)
Host: localhost
Porta: 3306
Banco: api
Usuário: root
Senha: root_pwd
✔️ Via terminal
docker exec -it mysql-api mysql -u root -p

Senha: root_pwd

▶️ Como rodar a aplicação
🔹 Usando Maven Wrapper
./mvnw spring-boot:run
🔹 Ou com Maven instalado
mvn spring-boot:run
🌐 Acessando a API

A aplicação roda por padrão em:

http://localhost:8080
📄 Documentação (Swagger)

Disponível em:

http://localhost:8080/
📌 Funcionalidades
CRUD de entidades:
Brasil
Japão
Persistência com JPA/Hibernate
Criação automática das tabelas (ddl-auto=update)
🛑 Parar e remover o container
docker stop mysql-api
docker rm mysql-api
👨‍💻 Autor
Enzo Wakao
Persistência com JPA/Hibernate
Criação automática das tabelas (ddl-auto=update)
🛑 Parar e remover o container
docker stop mysql-api
docker rm mysql-api
👨‍💻 Autor
Enzo Wakao
