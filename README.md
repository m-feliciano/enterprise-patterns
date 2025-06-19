# Padrões de Design em Java

## Sobre o Projeto

Este repositório é uma biblioteca de referência que documenta e exemplifica padrões de design de software implementados em Java. O projeto foi criado com propósito didático, oferecendo uma estrutura organizada de interfaces que servem como base para a implementação de diversos padrões de design.

## Estrutura do Projeto

O projeto está organizado em duas categorias principais:

### 1. Padrões Tradicionais (`patterns/`)

Implementação dos 23 padrões de design do GoF (Gang of Four) e outros padrões clássicos, divididos em três categorias:

- **Comportamentais (Behavioral)**: Focados em algoritmos e atribuição de responsabilidades entre objetos
  - Chain of Responsibility, Command, Interpreter, Iterator, Mediator
  - Memento, Observer, State, Strategy, Template Method

- **Criacionais (Creational)**: Tratam da criação de objetos de maneira adequada para cada situação
  - Abstract Factory, Builder, Factory Method, Object Pool, Prototype, Singleton

- **Estruturais (Structural)**: Lidam com a composição de classes e objetos
  - Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy

### 2. Padrões Empresariais (`enterprise/`)

Padrões comumente utilizados em aplicações empresariais e arquiteturas modernas:

- **API Gateway**: Fornece um ponto de entrada único para um conjunto de microserviços
- **Circuit Breaker**: Previne falhas em cascata em sistemas distribuídos
- **Dependency Injection**: Técnica onde um objeto recebe suas dependências externamente
- **Feature Toggle/Feature Flag**: Habilita/desabilita funcionalidades em tempo de execução
- **Producer-Consumer**: Gerencia fluxo de dados entre produtores e consumidores
- **Pub-Sub (Publicador-Assinante)**: Comunicação assíncrona entre componentes
- **Rate Limiting**: Controla a taxa de solicitações a um sistema
- **Repository**: Abstração para acesso a dados
- **Retry**: Mecanismo para tentar novamente operações que falharam
- **Saga**: Gerencia transações distribuídas em microsserviços
- **Specification**: Encapsulamento de regras de negócio
- **Strangler Fig**: Estratégia para migração gradual de sistemas legados

## Características do Projeto

- **Apenas Interfaces**: O projeto contém apenas interfaces e documentação, sem implementações concretas
- **Documentação Detalhada**: Cada padrão possui um README explicativo em português
- **Diagramas**: Representações visuais usando mermaid para ilustrar as estruturas dos padrões
- **Consistência**: Estrutura uniforme em todo o projeto para facilitar o aprendizado

## Como Utilizar

Este projeto serve como referência e base para:

1. **Aprendizado**: Estudar a estrutura e propósito de cada padrão de design
2. **Implementação**: Usar as interfaces como ponto de partida para suas próprias implementações
3. **Referência**: Consultar a documentação para entender quando e por que aplicar cada padrão

### Exemplo de Uso

Para implementar um padrão, você pode:

1. Examinar o README do padrão desejado para entender sua intenção e estrutura
2. Observar as interfaces definidas para o padrão
3. Criar suas próprias classes concretas que implementam essas interfaces
4. Aplicar o padrão no contexto do seu projeto

## Contribuição

Sinta-se à vontade para contribuir com:

- Melhorias na documentação
- Adição de novos padrões
- Correções ou clarificações

## Requisitos

- Java 8 ou superior
- Maven para gestão de dependências

## Licença

Este projeto é distribuído sob a licença MIT.
