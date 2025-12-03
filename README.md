# Projeto Casa Verde

Sistema de gestão imobiliária desenvolvido como requisito do 3º Ciclo para a disciplina de Teste, Manutenção e Análise de Sistemas. O projeto foca na aplicação de conceitos de orientação a objetos, arquitetura em camadas e testes automatizados.

## Arquitetura do Projeto

A solução foi estruturada em três módulos principais para garantir desacoplamento e testabilidade:

### 1. Núcleo (`casaverde-java`)
Módulo contendo o domínio da aplicação e lógica de negócios.
- Desenvolvido em Java puro (sem frameworks).
- Contém as entidades (`Cliente`, `Imovel`, `Visita`) e validações das regras de negócio.
- Isolado de dependências de infraestrutura ou banco de dados.
- Inclui testes unitários para validação de lógica.

### 2. API (`casaverde-api`)
Camada de aplicação responsável por expor os serviços via REST.
- Framework: Spring Boot.
- Endpoints disponíveis em `/api/clientes` e `/api/imoveis`.
- Persistência de dados em memória para fins de demonstração acadêmica.
- Porta padrão: `8080`.

### 3. Frontend e Testes (`frontend-selenium`)
Interface de usuário e suíte de testes automatizados.
- Interface desenvolvida em React com Vite.
- Scripts de automação (E2E) em Python utilizando Selenium WebDriver para validação de cadastros.
- Porta padrão: `5174`.

---

## Instruções de Execução

**Requisitos:** Java 17, Maven, Node.js e Python instalados.

### 1. Backend (Java & Spring Boot)

No diretório raiz do projeto, execute os comandos para instalar as dependências do núcleo e inicializar a API:

```bash
# Instalação do módulo core
mvn -f casaverde-java/pom.xml install

# Inicialização da API
mvn -f casaverde-api/pom.xml spring-boot:run
2. Frontend (React)
Em um novo terminal, acesse o diretório do frontend:

Bash

cd frontend-selenium
npm install
npm run dev -- --port 5174
3. Execução de Testes
Testes Automatizados (E2E com Selenium) Para execução dos scripts de validação de interface:

Bash

cd frontend-selenium
python executar_testes.py
Testes Unitários (Core) Para executar os testes de lógica de negócio no módulo Java puro:

Bash

mvn -f casaverde-java/pom.xml test
Stack Tecnológica
Linguagens: Java 17, Python, JavaScript/TypeScript.

Frameworks: Spring Boot, React.

Ferramentas: Maven, Vite, Selenium WebDriver.
