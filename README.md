# Publicando API RESTful na Nuvem Usando Spring Boot, Java e Railway.

```mermaid
classDiagram
    class Pessoa {
        +int id
        +String nome
        +String cpf
        +String telefone
        +String email
        +Endereco endereco
        +Produto produto
    }

    class Endereco {
        +String cep
        +String logradouro
        +String localidade
        +String bairro
        +String uf
    }

    class Produto {
        +int codigo
        +double preco
        +String nome
        +int quantidade
    }

    Pessoa "1" *-- "1" Endereco
    Pessoa "1" *-- "1" Produto

```
