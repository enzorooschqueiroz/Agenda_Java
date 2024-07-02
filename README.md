
# Sistema de Gerenciamento de Contatos

Um sistema simples de gerenciamento de contatos desenvolvido em Spring Boot.

## Funcionalidades

- Listar, buscar e excluir contatos
- Adicionar e atualizar contatos
- Marcar contatos como favoritos

## Tecnologias Utilizadas

- Java
- Spring Boot
- H2 Database (em memória para desenvolvimento)

## Configuração e Execução

### Pré-requisitos

- JDK 8 ou superior
- Maven 3.x

### Executar Localmente

1. Clone o repositório:
   ```
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. Execute a aplicação:
   mvn spring-boot:run

   Acesse em: `http://localhost:8080`

## API Endpoints

- **GET /contacts**: Lista todos os contatos
- **GET /contacts/{id}**: Busca um contato por ID
- **GET /contacts/favorites**: Lista contatos favoritos
- **POST /contacts**: Adiciona um novo contato
- **PUT /contacts/{id}**: Atualiza um contato existente
- **DELETE /contacts/{id}**: Exclui um contato por ID

## Repositório de Contatos (`ContactRepository`)

O `ContactRepository` utiliza Spring Data JPA e inclui um método personalizado para listar contatos favoritos.

## Entidade de Contato (`Contact`)

- Campos incluem nome, email, telefone, etc.
- Mapeamento JPA para a tabela `TBL_CONTACT`



