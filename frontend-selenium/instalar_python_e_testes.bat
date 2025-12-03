@echo off
echo ============================================
echo Instalador Python + Selenium (Testes)
echo ============================================
echo.

REM Verificar se Python está instalado
python --version >nul 2>&1
if %errorlevel% equ 0 (
    echo Python já está instalado
    goto :instalar_dependencias
) else (
    echo Python não encontrado
    echo Baixando Python...
    
    REM Baixar Python (versão estável)
    powershell -Command "Invoke-WebRequest -Uri 'https://www.python.org/ftp/python/3.11.5/python-3.11.5-amd64.exe' -OutFile 'python_installer.exe'"
    
    echo Instalando Python...
    python_installer.exe /quiet InstallAllUsers=1 PrependPath=1
    
    echo Aguardando instalação...
    timeout /t 30 /nobreak >nul
    
    REM Limpar instalador
    del python_installer.exe
    
    echo Python instalado com sucesso.
)

:instalar_dependencias
echo.
echo Instalando dependências do Selenium...
python -m pip install --upgrade pip
python -m pip install selenium==4.15.2 webdriver-manager==4.0.1 requests==2.31.0

echo.
echo Concluído.
echo Para executar os testes:
echo    python test_cadastro_pamella.py
echo    ou
echo    python executar_testes.py
echo.
pause