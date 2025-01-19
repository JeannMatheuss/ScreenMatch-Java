# Projeto ScreenMatch

## Descrição do Projeto
O **ScreenMatch** é um sistema desenvolvido para gerenciar informações sobre filmes, séries e episódios, utilizando uma integração com a API OMDB para buscar dados sobre conteúdos em tempo real. Ele calcula médias de avaliações, recomendações e a duração total de conteúdos para maratonas, seguindo os princípios da Programação Orientada a Objetos (POO) para organizar e processar dados de forma modular e reutilizável.

---

## Funcionalidades do Sistema
- **Busca de filmes/séries**:
  - Conexão com a API OMDB para buscar informações sobre títulos.
  - Manipulação e tratamento dos dados recebidos no formato JSON.

- **Gerenciamento de Títulos**:
  - Criação de objetos representando filmes e séries com atributos como nome, ano de lançamento e duração.
  - Cálculo de médias de avaliações e soma total de avaliações.

- **Exportação de Dados**:
  - Exporta informações dos títulos pesquisados para um arquivo JSON.

---

## Tecnologias Utilizadas
- **Java**: Linguagem principal para o desenvolvimento do sistema.
- **Biblioteca Gson**: Para conversão entre JSON e objetos Java, além de formatação e manipulação de dados.
- **API OMDB**: Serviço externo para obtenção de informações sobre filmes e séries.
- **Pacotes e Classes**:
  - Organização modular em pacotes como `modelos`, `principal` e `exception`.

---

## O que Eu Aprendi
Durante o desenvolvimento deste projeto, aprofundei conceitos como:

- **Programação Orientada a Objetos (POO)**:
  - **Encapsulamento**: Controle de acesso aos atributos através de getters e setters.
  - **Herança**: Criação da classe base `Titulo` e especialização com outras classes como `TituloOmdb`.
  - **Polimorfismo**: Métodos que aceitam diferentes tipos de objetos derivados de uma classe base.

- **Integração com APIs**:
  - Conexão com APIs externas utilizando `HttpClient`.
  - Manipulação de URIs e tratamento de respostas HTTP.

- **Tratamento de Exceções**:
  - Implementação de classes customizadas como `ErroDeConversaoDeAnoException` para tratar erros específicos.
  - Uso de blocos `try-catch` para capturar e lidar com diferentes tipos de erros.

- **Manipulação de JSON**:
  - Uso da biblioteca Gson para deserializar dados em objetos Java.
  - Geração de arquivos JSON com dados formatados.

---

## Pontos de Melhoria
- **Validação de entrada**:
  - Melhorar a validação nos métodos `set` para evitar valores inconsistentes, como anos inválidos.

- **Persistência de dados**:
  - Conectar o sistema a um banco de dados para armazenar filmes e avaliações.

- **Interface gráfica**:
  - Criar uma UI amigável para que o usuário interaja com o sistema visualmente.

- **Testes Automatizados**:
  - Implementar testes unitários para garantir a qualidade do código e a correta funcionalidade.

---

## Próximos Passos
- **Adicionar suporte a diferentes categorias de conteúdos**.
- **Aplicar padrões de design (como Factory e Builder)** para criar objetos com maior flexibilidade.
- **Melhorar a usabilidade e escalabilidade do sistema** com novas funcionalidades e uma interface gráfica.
- **Testes automatizados** para verificar os fluxos principais do sistema.

Este projeto continua sendo uma base sólida para aprendizado e aprimoramento na linguagem Java e no desenvolvimento de sistemas baseados em API e POO.
