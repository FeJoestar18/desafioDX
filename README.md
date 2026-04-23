# Desafio Duxus

## Como executar

### Com banco PostgreSQL
1. Configure as variáveis de ambiente:
   - `DB_URL=jdbc:postgresql://localhost:5432/duxus`
   - `DB_USERNAME=seu_usuario`
   - `DB_PASSWORD=sua_senha`
   - `SPRING_PROFILES_ACTIVE=postgres`
2. Inicie a aplicação:
   - `mvn spring-boot:run`

### Com banco em memória H2
1. Defina o perfil H2:
   - `SPRING_PROFILES_ACTIVE=h2`
2. Inicie a aplicação:
   - `mvn spring-boot:run`

### Para executar testes em memória
1. `mvn test`

## Perfis disponíveis
- `postgres`: usa PostgreSQL com variáveis `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`
- `h2`: usa banco H2 em memória
- `test`: usa banco H2 em memória para testes automatizados

## Endpoints disponíveis
Base: `/api`

- `GET /api/time?data=yyyy-MM-dd`
- `GET /api/integrante-mais-usado?inicio=yyyy-MM-dd&fim=yyyy-MM-dd`
- `GET /api/time-mais-recorrente?inicio=yyyy-MM-dd&fim=yyyy-MM-dd`
- `GET /api/funcao-mais-recorrente?inicio=yyyy-MM-dd&fim=yyyy-MM-dd`
- `GET /api/clube-mais-recorrente?inicio=yyyy-MM-dd&fim=yyyy-MM-dd`
- `GET /api/contagem-clubes?inicio=yyyy-MM-dd&fim=yyyy-MM-dd`
- `GET /api/contagem-funcoes?inicio=yyyy-MM-dd&fim=yyyy-MM-dd`
- `POST /api/integrantes`
  - Body JSON: `{ "nome": "Bangalore", "funcao": "Atacante" }`
- `POST /api/times`
  - Body JSON: `{ "nomeDoClube": "Falcons", "data": "2021-01-15", "integranteIds": [1, 2, 3] }`

## Observações
- O perfil ativo pode ser definido via `SPRING_PROFILES_ACTIVE`
- Os testes usam `application-test.properties` e H2 em memória
