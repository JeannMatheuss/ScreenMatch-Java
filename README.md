# Projeto ScreenMatch

## Descrição do Projeto
O **ScreenMatch** é um sistema desenvolvido para gerenciar informações sobre filmes, séries e episódios, calculando médias de avaliações, recomendações e a duração total de conteúdos para maratonas. Ele utiliza princípios fundamentais de Programação Orientada a Objetos (POO) para organizar e processar dados, tornando o código mais modular e reutilizável.

---

## O que Eu Aprendi
Durante o desenvolvimento deste projeto, aprendi e aprofundei conceitos como:

- **Programação Orientada a Objetos (POO)**:
  - **Encapsulamento**: Protegi os atributos das classes e disponibilizei métodos para manipulá-los de forma controlada.
  - **Herança**: Reutilizei atributos e métodos comuns na classe base `Titulo`, e especializei em subclasses como `Filme` e `Serie`.
  - **Polimorfismo**: Criei métodos que aceitam múltiplos tipos, utilizando classes base e interfaces.
  - **Interfaces**: Usei a interface `Classificavel` para padronizar métodos de classificação.

- **Reuso de código**:
  - Evitei duplicação ao criar métodos e classes que servem a múltiplas funcionalidades.
  - Generalizei funcionalidades com a classe base `Titulo`.

- **Trabalhando com métodos utilitários**:
  - Desenvolvi cálculos, como médias de avaliações e tempos totais, de forma organizada e eficiente.

- **Estruturação de Projetos Java**:
  - Organizei o código em pacotes e segui boas práticas de estruturação.

---

## Pontos de Melhoria
Apesar de o projeto estar funcional, identifiquei algumas áreas para melhorias futuras:
- **Validação de entrada**: Implementar validações nos setters para garantir que valores inválidos não sejam atribuídos, como anos de lançamento futuros ou duração negativa.
- **Persistência de dados**: Integrar o sistema a um banco de dados para armazenar filmes, séries e avaliações.
- **Interface gráfica**: Adicionar uma interface de usuário (UI) para tornar o sistema mais acessível e amigável.
- **Testes automatizados**: Desenvolver testes unitários para validar as funcionalidades do projeto.
- **Internacionalização**: Permitir que o sistema suporte múltiplos idiomas.

---

## Reflexão
Este projeto foi uma excelente oportunidade para consolidar conceitos de POO em Java e aplicar boas práticas de desenvolvimento. Além disso, aprendi a importância de estruturar bem o código para facilitar futuras manutenções e expansões.

---

## Próximos Passos
- Estender o sistema para incluir mais funcionalidades, como listagem de conteúdos recomendados e relatórios detalhados.
- Aplicar design patterns, como Factory ou Builder, para melhorar a criação de objetos.
- Integrar uma API externa para buscar informações de filmes e séries.

Este projeto é um marco importante na minha jornada como desenvolvedor Java, e estou animado para continuar aprimorando-o e explorando novas possibilidades.
