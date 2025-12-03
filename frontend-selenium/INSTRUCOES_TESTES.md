# Guia Rápido dos Testes

Este projeto tem uma página de cadastro simples e uma suíte de testes em Python com Selenium. A ideia é validar o cadastro e a navegação entre páginas.

Dados usados nos testes:
- Nome: Pamella Oliveira
- Telefone: 8199999-9999
- Email: pamela@gmail.com
- Senha: nininha123
- SMS: 111111

Testes implementados:
- Teste 1: `send_keys` e `clear` no campo Nome
- Teste 2: `get_attribute` (placeholders e tipos dos inputs)
- Teste 3: `is_selected`/habilitado/visível
- Teste 4: `current_url` e redirecionamento para SMS
- Teste 5: `ActionChains` (hover e interações)
- Extra: fluxo completo de cadastro

Como executar
1) Instalar dependências do frontend
   - `npm install`
2) Iniciar o servidor
   - `npm run dev -- --port 5174`
   - Acesse `http://localhost:5174/`
3) Instalar dependências de testes (Python)
   - `python -m pip install -r requirements.txt`
4) Executar todos os testes
   - `python executar_testes.py`
5) Executar apenas o último teste (fluxo completo)
   - `python executar_testes.py --ultimo`

Observações
- Os testes usam as páginas locais (`register.html`, `sms-confirmation.html`, etc.).
- Se você usar outra porta, ajuste as URLs nos testes.
- Mensagens do Chrome/DevTools podem aparecer; não atrapalham a execução.

Solução de problemas
- Verifique se o servidor está ativo (`npm run dev`).
- Confirme se os IDs dos campos batem com o HTML (`fullName`, `phoneNumber`, `email`, `password`).
- Atualize o Chrome se o WebDriver falhar.