# Plano de Implementação – Backend Spring Boot alinhado ao front existente (step‑by‑step)

## Leitura do projeto (contexto)

* Front é Vite/HTML com páginas: `register.html`, `sms-confirmation.html`, `home.html`, `listings.html`, `property-details.html`, `chat-detail.html`, `filter.html`.

* Fluxos dos testes Selenium: cadastro → SMS → home; navegação por listagem/ detalhes; chat com mensagem rápida.

* Módulo `casaverde-java` já tem regras de negócio (Cliente, Imóvel, Visita) e 24 testes OK.

## Objetivo

* Backend Spring Boot que cubra exatamente o que o front usa hoje: **cadastro/login**, **listar/editar imóveis**, **agendar visitas** (opcional), e **CORS** liberado para `5174`.

* Tudo simples, comentado com linguagem direta, sem banco (memória).

## Estrutura da API

* `casaverde-api/`

  * `Application.java` (sobe o servidor)

  * `controller/ClienteController.java`

  * `controller/ImovelController.java`

  * `controller/VisitaController.java` (opcional para visitas)

  * `store/` (Mapas em memória)

  * `dto/` (requisições/respostas)

  * `pom.xml` (Spring Boot + dependência do `casaverde-java`)

## Endpoints mapeados para o front

* Cadastro/login (usados por `register.html` e possivelmente `sms-confirmation.html`):

  * `POST /api/clientes` → cria cliente (nome, email, senha) e retorna `id` e `ativo`.

  * `POST /api/login` → autentica (email, senha) e retorna `{ok: true/false}`.

* Imóveis (usados por `listings.html` e `property-details.html`):

  * `POST /api/imoveis` → cria imóvel (titulo, endereco, preco, quartos).

  * `GET /api/imoveis` → lista todos.

  * `GET /api/imoveis/{id}` → detalhes (para a página de detalhes).

  * `PUT /api/imoveis/{id}/preco` → atualiza preço.

  * `PUT /api/imoveis/{id}/ativar` / `PUT /api/imoveis/{id}/desativar` → disponibilidade.

* Visitas (apoia agendamento futuro, pode ser usado em `messages.html`):

  * `POST /api/visitas` → cria (clienteId, imovelId, dataHora futura).

  * `PUT /api/visitas/{id}/cancelar` / `confirmar` / `reagendar`.

## CORS

* Colocar `@CrossOrigin(origins="http://localhost:5174")` nos controladores para permitir chamadas do front.

## Armazenamento simples

* `AtomicLong` para gerar IDs.

* `ConcurrentHashMap<Long, Cliente/Imovel/Visita>` como repositório básico.

* Comentários do tipo: “guarda em memória só pra demo”.

## DTOs

* `ClienteCreateDTO {nome, email, senha}`; `LoginDTO {email, senha}`.

* `ImovelCreateDTO {titulo, endereco, preco, quartos}`; `PrecoDTO {novoPreco}`.

* `VisitaCreateDTO {clienteId, imovelId, dataHora}`; `ReagendarDTO {novaDataHora}`.

## Testes

* Manter `casaverde-java` com 24 testes (já verdes).

* Criar `ClienteControllerTest`, `ImovelControllerTest`, `VisitaControllerTest` com 8 métodos cada usando MockMvc (simples: cria, valida erros, atualiza, lista).

## Passo a passo (step‑by‑step)

1. Criar módulo `casaverde-api` (Spring Boot minimal).
2. Adicionar dependência ao `casaverde-java` (reuso de Model/Service).
3. Implementar Stores em memória e DTOs básicos.
4. Implementar controladores com endpoints acima, usando Services já prontos.
5. Adicionar `@CrossOrigin` para o front.
6. Escrever testes MockMvc (3 classes, 8 métodos cada).
7. Subir backend (`mvn spring-boot:run`) e o front (`npm run dev`).
8. Ajustar `register.html` para chamar `POST /api/clientes` antes de ir para SMS.
9. Ajustar `listings.html` para preencher listagem com `GET /api/imoveis`.
10. Validar com Selenium: o fluxo deve continuar funcionando, agora com dados vindo da API onde faz sentido.

## Exemplo de integração no front (simples e direto)

```js
// register.html – após validação local
fetch('http://localhost:8080/api/clientes', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ nome: fullName, email, senha: password })
}).then(r => r.json()).then(() => {
  // segue pro SMS
  window.location.href = 'sms-confirmation.html'
}).catch(() => alert('Erro ao criar cliente'))
```

## Critérios de aceite

* Backend em `8080` com controladores funcionando.

* CORS liberado para `5174`.

* Testes de controladores passam.

* Front chama pelo menos cadastro e listagem via API (exemplos funcionando).

* Comentários curtos e informais; código simples.

