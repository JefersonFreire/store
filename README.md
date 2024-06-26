# Publicando API RESTful na Nuvem Usando Spring Boot, Java e Railway.
## Desafio de projeto Bootcamp Santander 2024 Dio.
### Esse projeto tem como objetivo entregar uma Api RESTful utilizando linguagem Java, Spring Boot e Railway.
### Como é um projeto qual eu tinha em mente para estudos, ainda não possui regras de negócios apenas o objetivo de entrega do desafio.

###Link da implantação no Railway [Desafio de Projeto](https://santander-bootcamp2024-dio.up.railway.app/swagger-ui/index.html#/)


```mermaid
classDiagram
    class Cliente {
        Long id
        String nome
        String cpf
        String telefone
        String email
        Endereco endereco
        Produto produto
        List~Compra~ compras
        +Cliente()
        +Response execute(Request request, Request.Options options) IOException
    }

    class Compra {
        Long id
        Cliente cliente
        Produto produto
        int quantidade
        Date dateCompra
        +Compra()
        +Compra(Cliente cliente, Produto produto, int quantidade)
    }

    class Endereco {
        String cep
        String logradouro
        String localidade
        String bairro
        String uf
        +Endereco()
    }

    class Produto {
        Long codigo
        BigDecimal preco
        String nome
        int quantidade
        List~Compra~ compras
        +Produto()
        +Produto(String nome, BigDecimal preco, int quantidade)
    }

    Cliente "1" --> "0..*" Compra : compras
    Cliente "1" --> "1" Endereco : endereco
    Cliente "1" --> "1" Produto : produto
    Compra "1" --> "1" Cliente : cliente
    Compra "1" --> "1" Produto : produto
    Produto "1" --> "0..*" Compra : compras

```
