# Gestao de Loja de Roupa

## 🚀 Demanda

Desenvolver uma API RESTful (back-end) utilizando Springboot para Gestão de Loja de Roupas.

### Entidades:

- `Cliente:` id, nome, cpf, idade e telefone.<br>
- `funcionário:` id, nome, idade e matrícula.<br>
- `Venda:` id, endereço da entrega e valor total.<br>
- `Produto:` id, nome, valor.<br>

### Relacionamentos:

- Um cliente pode realizar várias compras, ou seja, pode estar vinculado a várias vendas, mas
uma venda só pode estar associada a um cliente.
- Um funcionário pode realizar várias vendas, mas uma venda só pode estar associada a um
funcionário.
- Um funcionário pode realizar várias vendas, mas uma venda só pode estar associada a um
funcionário.

### Regras de negócio e validações:

- A entidade principal é Venda. O sistema deve permitir salvar a venda com o cliente, o
funcionário e os produtos em uma única requisição (cascade).
- Todos os atributos das entidades são obrigatórios, exceto endereço de entrega (validation).
- Além de métodos básicos de CRUD (findAll, findById, delete, save e update), implementar
ao menos 3 filtros (findBy...), sendo 01 com JPQL e 02 com métodos automáticos para cada
repository de cada uma das 4 entidades.
- Todas as entidades devem possuir endpoints, então, haverá controller, service, repositor
para cada entidade.

## Requesitos que serão avaliados

- `Padão organizacionais do Spring Boot:`
- `Persistência com SpringDataJPA:`
- `Estrututa de requisições HTTP:`
- `Funcionamento das requisições pelo POSTMAN:`
- `Solução do problema (interpretação):`

## Dependências

- SPRING WEB
- SPRING DATA JPA
- SPRING VALIDATION
- MYSQL CONECTOR

## Estrutura do projeto

📁 Gestao de loja roupa
└── 📁 src/main/java
    ├── 📁 app.controller
    │   ├── 📁 clienteController
    │   ├── 📁 funcionarioController
    │   ├── 📁 produtoController
    │   ├── 📁 vendaController
    ├── 📁 app.entity
    │   ├── 📁 Cliente
    │   ├── 📁 Funcionario
    │   ├── 📁 Produto
    │   ├── 📁 Venda
    │── 📁 app.repository
    │   ├── 📁 clienteRepository
    │   ├── 📁 funcionarioRepository
    │   ├── 📁 produtoRepository
    │   ├── 📁 vendaRepository
    ├── 📁 app.service
    │    ├── 📁 cliente.Service
    │    ├── 📁 funcionario.Service
    │    ├── 📁 produto.Service
    │    ├── 📁 venda.Service
├── 📁 src/main/resources
├── 📁 src/test/java
├── 📁 JRE System Library
├── 📁 Maven  Dependencies
├── 📁  src
├── 📁 target
├── 📁 POM.XML 

## 💻 Trello

[TRELLO](https://trello.com/b/19atZkn1/desenvolvimento-de-gestao)

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/CarlosFeliponi">
        <img src="https://avatars.githubusercontent.com/u/107933029?v=4" width="100px;" alt="Carlos Feliponi Github"/><br>
        <sub>
          <b>Carlos Feliponi</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Exxodius">
        <img src="https://avatars.githubusercontent.com/u/119608284?v=4" width="100px;" alt="Gabriel Pletsch Github"/><br>
        <sub>
          <b>Gabriel Pletsch</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/PedroHenriqueAbreuF">
        <img src="https://avatars.githubusercontent.com/u/101679821?v=4" width="100px;" alt="Carlos Antunes Github"/><br>
        <sub>
          <b>Carlos Antunes</b>
        </sub>
      </a>
    </td>
  </tr>
</table> 
