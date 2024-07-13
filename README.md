# Ordering System Microservice - Menu

## Descrição

O `ordering-system-microservice-menu` é um microserviço desenvolvido em Java 17 com Spring Boot. Ele é responsável por exibir informações sobre os itens do cardápio da Blues Burger.

## Estrutura do Projeto

```plaintext
ordering-system-microservice-menu/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │       └── menu/
│   │   │          ├── adapters/
│   │   │          ├── configuration/
│   │   │          └── core/
│   │   │              └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-production.properties
│   │       ├── application-test.properties
│   │       └── data.sql
│   ├── test/
│   │   ├── java/
│   │   │   └── orderingmenu/
├── Dockerfile
├── pom.xml
└── README.md
```

## Tecnologias Utilizadas
 - Java 17
 - Spring Boot
 - Spring Data JPA
 - Banco de Dados SQL
 - Maven

## Estrutura do Código
 - Controller: Contém as classes responsáveis por expor e se integrar às APIs REST.
 - Service: Contém as classes de serviço que encapsulam a lógica de negócio.
 - Repository: Contém as interfaces que interagem com o banco de dados.
 - Model: Contém as classes que representam as entidades do banco de dados.

## Endpoints
 - `GET /api/v1/menu`: Retorna a lista de pratos disponíveis.
 - `GET /api/v1/menu{id}`: Retorna as informações de um prato específico por ID.
 - `POST /api/v1/menu`: Cria as informações de um item.
 - `PUT /api/v1/menu{menuItemId}`: Atualiza as informações de um Item específico por ID.
 - `DELETE /api/v1/menu{menuItemId}`: Deleta as informações de um Item específico por ID.

## Executando a aplicação local

Para rodar a aplicação local, dentro de .run existe uma configuração específica para tal objetivo.

Após a aplicação ter sido inicializada, é possível verificar o banco criado através do console do `H2-Database`
disponível em: http://localhost:8080/h2-console
