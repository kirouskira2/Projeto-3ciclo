# Projeto Casa Verde

Sistema de gestão imobiliária desenvolvido como requisito do 3º Ciclo para a disciplina de Teste, Manutenção e Análise de Sistemas. O projeto foca na aplicação de conceitos de orientação a objetos, arquitetura em camadas e testes automatizados.

## Arquitetura do Projeto

A solução foi estruturada em três módulos principais para garantir desacoplamento e testabilidade:

### 1. Núcleo (`casaverde-java`)
Módulo contendo o domínio da aplicação e lógica de negócios.
- Desenvolvido em Java puro (sem frameworks)
- Entidades: Cliente, Imóvel, Visita
- Validações das regras de negócio
- Isolado de dependências de infraestrutura ou banco de dados
- Inclui testes unitários para validação de lógica

### 2. API (`casaverde-api`)
Camada de aplicação responsável por expor os serviços via REST.
- Framework: Spring Boot
- Endpoints: `/api/clientes`, `/api/imoveis`, `/api/visitas`
- Persistência de dados em memória (demonstração acadêmica)
- Porta padrão: `8080`

### 3. Frontend e Testes (`frontend-selenium`)
Interface de usuário e suíte de testes automatizados.
- Interface em React com Vite
- Automação E2E em Python com Selenium WebDriver
- Porta padrão: `5174`

---

## Instruções de Execução

Requisitos: Java 17, Maven, Node.js e Python instalados.

### 1. Backend (Java & Spring Boot)
No diretório raiz do projeto:
```bash
mvn -f casaverde-java/pom.xml install
mvn -f casaverde-api/pom.xml spring-boot:run
```

### 2. Frontend (React)
```bash
cd frontend-selenium
npm install
npm run dev -- --port 5174
```

### 3. Execução de Testes
Testes Automatizados (E2E com Selenium):
```bash
cd frontend-selenium
python executar_testes.py
```

Testes Unitários (Core):
```bash
mvn -f casaverde-java/pom.xml test
```

---

## Stack Tecnológica
- Linguagens: Java 17, Python, JavaScript/TypeScript
- Frameworks: Spring Boot, React
- Ferramentas: Maven, Vite, Selenium WebDriver
