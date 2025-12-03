"""
🎯 EXECUTOR DE TESTES - CADASTRO PAMELLA OLIVEIRA
===============================================
Script para executar todos os testes automatizados
===============================================
"""

import subprocess
import sys
import os
import argparse

def verificar_servidor():
    """Verifica se o servidor está rodando"""
    print("🔍 Verificando se o servidor está rodando...")
    try:
        import requests
        response = requests.get("http://localhost:5174/register.html", timeout=5)
        if response.status_code == 200:
            print("✅ Servidor rodando em http://localhost:5174")
            return True
        else:
            print("❌ Servidor não está respondendo")
            return False
    except:
        print("❌ Servidor não está rodando ou não acessível")
        print("💡 Execute 'npm run dev' antes de rodar os testes")
        return False

def instalar_dependencias():
    """Instala as dependências necessárias"""
    print("📦 Instalando dependências...")
    try:
        subprocess.check_call([sys.executable, "-m", "pip", "install", "selenium", "webdriver-manager", "requests"])
        print("✅ Dependências instaladas com sucesso!")
        return True
    except subprocess.CalledProcessError:
        print("❌ Erro ao instalar dependências")
        return False

def mostrar_resumo_testes():
    """Mostra resumo dos testes que serão executados"""
    print("\nRESUMO DOS TESTES:")
    print("=" * 60)
    print("[TESTE 1] send_keys() e clear()")
    print("   -> Cadastro: Escrever -> Apagar -> Reescrever nome")
    print()
    print("[TESTE 2] get_attribute()")
    print("   -> Cadastro -> SMS -> Home [PARA NA HOME]")
    print()
    print("[TESTE 3] is_selected()")
    print("   -> Home -> Filtros -> Home -> Pesquisa 'casa moderna' + Enter [FECHA]")
    print()
    print("[TESTE 4] current_url")
    print("   -> Listings -> Property -> Scroll -> Chat")
    print()
    print("[TESTE 5] ActionChains")
    print("   -> Chat -> Mensagem rapida + Enter")
    print()
    print("[TESTE 6] Navegacao Completa")
    print("   -> Home -> Scroll -> Favoritos -> Swipe -> Delete")
    print("=" * 60)

def executar_testes(ultimo: bool = False):
    """Executa os testes automatizados"""
    print("\n" + "="*60)
    print("🚀 INICIANDO EXECUÇÃO DOS TESTES AUTOMATIZADOS")
    print("="*60)
    if ultimo:
        print("🔧 Modo: executando apenas o último teste (teste 06)")
    
    # Verificar se o arquivo de teste existe
    if not os.path.exists("test_cadastro_pamella.py"):
        print("❌ Arquivo test_cadastro_pamella.py não encontrado!")
        return False
    
    try:
        # Monta alvo dos testes
        if ultimo:
            alvo = "test_cadastro_pamella.TestCadastroPamella.test_06_fluxo_completo_cadastro"
        else:
            alvo = "test_cadastro_pamella.py"
        
        # Executar testes com unittest
        result = subprocess.run([
            sys.executable, "-m", "unittest", 
            alvo, "-v"
        ], capture_output=True, text=True)
        
        print("📊 SAÍDA DOS TESTES:")
        print("-" * 40)
        print(result.stdout)
        
        if result.stderr:
            print("⚠️  AVISOS/ERROS:")
            print(result.stderr)
        
        if result.returncode == 0:
            if ultimo:
                print("\n🎉 Último teste passou com sucesso!")
            else:
                print("\n🎉 TODOS OS TESTES PASSARAM COM SUCESSO!")
            print("✅ Pronto para apresentação!")
        else:
            print(f"\n❌ Alguns testes falharam (código: {result.returncode})")
        
        return result.returncode == 0
        
    except Exception as e:
        print(f"❌ Erro ao executar testes: {e}")
        return False

def mostrar_proximos_passos(sucesso):
    """Mostra próximos passos baseado no resultado"""
    if sucesso:
        print("\nPROXIMOS PASSOS PARA APRESENTACAO:")
        print("=" * 60)
        print("1. Grave um video executando este script")
        print("2. Mostre o codigo explicando cada teste:")
        print("   - TESTE 1: send_keys() e clear() - Manipulacao de campos")
        print("   - TESTE 2: get_attribute() - Verificacao de atributos")
        print("   - TESTE 3: is_selected() - Estados de elementos")
        print("   - TESTE 4: current_url - Navegacao e redirecionamentos")
        print("   - TESTE 5: ActionChains - Interacoes avancadas")
        print("   - TESTE 6: Fluxo completo de navegacao")
        print()
        print("3. Demonstre os 5 tipos OBRIGATORIOS do Selenium:")
        print("   [OK] send_keys() e clear()")
        print("   [OK] get_attribute()")
        print("   [OK] is_selected() / is_enabled() / is_displayed()")
        print("   [OK] current_url (redirecionamentos)")
        print("   [OK] ActionChains (hover/movimentos)")
        print()
        print("4. Compare a aplicacao com o design do Figma")
        print("5. Apresente em ate 10 minutos")
        print("=" * 60)
    else:
        print("\nPASSOS PARA CORRIGIR:")
        print("=" * 60)
        print("1. Verifique se o servidor esta rodando:")
        print("   -> npm run dev")
        print()
        print("2. Verifique se o ChromeDriver esta atualizado:")
        print("   -> O Selenium Manager faz isso automaticamente")
        print()
        print("3. Verifique os IDs dos elementos HTML:")
        print("   -> fullName, phoneNumber, email, password")
        print("   -> sign-up-button, confirm-button")
        print()
        print("4. Execute os testes novamente")
        print("=" * 60)

def main():
    """Função principal"""
    parser = argparse.ArgumentParser(description="Executor de testes - Cadastro Pamella Oliveira")
    parser.add_argument("--ultimo", action="store_true", help="Executa apenas o último teste (test_06_fluxo_completo_cadastro)")
    args = parser.parse_args()

    print("🎯 EXECUTOR DE TESTES AUTOMATIZADOS")
    print("=" * 50)
    print("Projeto: Cadastro Pamella Oliveira")
    print("Testes: 5 obrigatórios + 1 extra")
    print("=" * 50)
    
    # Verificar servidor
    if not verificar_servidor():
        print("\n💡 INSTRUÇÕES:")
        print("1. Abra outro terminal")
        print("2. Execute: npm run dev")
        print("3. Aguarde o servidor iniciar")
        print("4. Execute este script novamente")
        return
    
    # Instalar dependências
    if not instalar_dependencias():
        return
    
    # Executar testes
    sucesso = executar_testes(ultimo=args.ultimo)
    
    if sucesso and not args.ultimo:
        print("\n📹 PRÓXIMOS PASSOS PARA APRESENTAÇÃO:")
        print("1. Grave um vídeo executando os testes")
        print("2. Mostre o código explicando cada teste")
        print("3. Demonstre os 5 tipos obrigatórios:")
        print("   - send_keys() e clear()")
        print("   - get_attribute()")
        print("   - is_selected()")
        print("   - current_url (redirecionamento)")
        print("   - ActionChains (hover)")
        print("4. Compare com o design do Figma")
        print("5. Apresente em até 10 minutos")
    
    print("\n🔚 Execução finalizada!")

if __name__ == "__main__":
    main()