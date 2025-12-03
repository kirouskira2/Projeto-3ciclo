# Projeto de Testes Automatizados (Selenium)

Este projeto tem uma aplicação web simples e uma suíte de testes em Python usando Selenium. A ideia é validar o fluxo de cadastro e a navegação entre páginas.

Tecnologias usadas:
- React + TypeScript (Vite)
- Python + Selenium
- WebDriver (Chrome)

Como rodar o projeto:
1) Instalar dependências do frontend
   - `npm install`
2) Iniciar o servidor
   - `npm run dev -- --port 5174`
   - A aplicação vai abrir em `http://localhost:5174/`
3) Instalar dependências dos testes (Python)
   - `python -m pip install -r requirements.txt`
4) Executar todos os testes
   - `python executar_testes.py`
5) Executar somente o último teste (fluxo completo)
   - `python executar_testes.py --ultimo`

Observações:
- Os testes usam a página `http://localhost:5174/register.html`.
- Se você preferir rodar em outra porta (ex.: 5173), ajuste as URLs nos arquivos de teste.
- Mensagens do Chrome/DevTools podem aparecer no terminal; não atrapalham os testes.

Qualquer dúvida, é só rodar os comandos acima que tudo funciona.
