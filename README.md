# SPRING-BOOT-COM-MYSQL
Sistema com spring-boot + MYSQL + docker-compose e REST para listar, inserir e atualizar informações no banco de dados, usando a linguagem Java.
Através de um script no caminho: \src\main\resources chamado schema.sql o  hibernate vai criar as tabelas no banco ao subir a aplicação.
Para rodar o sistema execute os comandos abaixo na pasta raiz do projeto.

# compilar o projeto (através do maven wrapper)
./mvnw.cmd clean install


# Subindo a aplicação com Docker-compose
docker-compose up --build --force-recreate

Através do Navegador ou Postman faça as requisições através da porta 8080.
localhost:8080/