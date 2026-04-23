# Duxus Desafio - API de Gerenciamento de Escalação de Times

API REST desenvolvida com Spring Boot para gerenciamento de times, integrantes e análises de escalações.

> Este repositório contém o backend da solução. O frontend foi implementado em outro repositório separado.

## Visão Geral

Este projeto resolve um desafio técnico com foco em regras de negócio complexas, arquitetura limpa e boas práticas.

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA + Hibernate
- PostgreSQL
- H2 Database
- Docker
- Swagger (OpenAPI)
- JUnit 5 + Mockito

## Documentação

A documentação foi separada para melhor organização:

- Arquitetura e Design: [Arquitetura](documentacao/arquitetura.md)
- Regras de Negócio e Processos: [Negócios](documentacao/negocios.md)
- Como rodar o projeto: [Como Rodar](documentacao/run.md)
- Design Patterns: [Design Patterns](documentacao/patterns.md)
- Endpoints, HTTP e Testes: [Endpoints](documentacao/http.md)
- Frontend: [Sobre o Front-End](documentacao/frontend.md)

## &#x20;Acesso rápido

- Swagger UI: <http://localhost:8080/swagger-ui/index.html>
- API Docs: <http://localhost:8080/v3/api-docs>

## Frontend

- Repositório do frontend: <https://github.com/FeJoestar18/desafioDX-Front.git>
- O frontend consome esta API via REST.

## Testes

```bash
mvn clean test
```

## Estrutura do Projeto

- WebApi
- Application
- Domain
- Infrastructure

## Futuras Implementações

Visando a escalabilidade, segurança e o amadurecimento da plataforma como um produto SaaS focado na gestão completa de e-sports e equipes esportivas, os seguintes planos de crescimento estão mapeados:

### Segurança e Performance

- **Rate Limiting:** Implementação de limite de requisições por IP/Usuário para proteger a API contra ataques de DDoS e *brute-force*, garantindo a estabilidade dos serviços.
- **Autenticação e Autorização (JWT):** Criação de um sistema robusto de Login e controle de acesso baseado em *Roles* (Ex: Admin, Owner de Time, Integrante) utilizando JSON Web Tokens.
- **Cache com Redis:** Otimização dos endpoints de análise e relatórios (como "Time mais recorrente" e "Contagens"), armazenando em memória os resultados de consultas pesadas para reduzir drasticamente a carga no PostgreSQL e o tempo de resposta (latência).

### Arquitetura Orientada a Eventos

- **Apache Kafka:** Adoção do Kafka para desacoplar processos assíncronos. Por exemplo, ao criar uma nova escalação (Time), um evento de `ESCALACAO_CONFIRMADA` seria publicado no Kafka, permitindo que outros microserviços (como um sistema de envio de e-mails/Push Notifications) notifiquem instantaneamente os integrantes de que eles foram convocados para o próximo jogo, sem travar a resposta da API principal.

### Novos Recursos de Produto

- **Dashboard de Integrantes:** Uma página dedicada no frontend onde os integrantes podem ver seu próprio histórico de times, funções exercidas, estatísticas pessoais e agenda de jogos.
- **Painel de Gestão (Owners):** Um portal focado para os donos dos times (Owners) gerenciarem seus elencos, avaliarem a performance dos seus integrantes e planejarem escalações futuras com base em dados.
- **Sistema de Pagamentos:** Integração com gateways de pagamento (como Stripe ou Mercado Pago) diretamente na plataforma. Isso permitirá que os *Owners* paguem os salários, prêmios ou cachês de campeonatos diretamente para as carteiras virtuais dos integrantes vinculados aos seus times.

## Licença

Uso Educacional / desafio técnico para fins de aprendizado e demonstração de habilidades. Não é permitido uso comercial sem autorização prévia.
