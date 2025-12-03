/**
 * Validador de arquivos de teste
 * Verifica se os principais arquivos existem e contêm termos esperados
 */

import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

console.log('Validando arquivos de teste...');
console.log('='.repeat(50));

const arquivosNecessarios = [
  'test_cadastro_pamella.py',
  'executar_testes.py',
  'requirements.txt',
  'register.html',
  'sms-confirmation.html',
];

let todosOk = true;

arquivosNecessarios.forEach((arquivo) => {
  const caminho = path.join(__dirname, arquivo);
  if (fs.existsSync(caminho)) {
    const stats = fs.statSync(caminho);
    console.log(`${arquivo} - OK (${stats.size} bytes)`);

    if (arquivo === 'test_cadastro_pamella.py') {
      const conteudo = fs.readFileSync(caminho, 'utf8');
      const termos = [
        'send_keys',
        'get_attribute',
        'is_selected',
        'current_url',
        'ActionChains',
        'Pamella Oliveira',
        '8199999-9999',
        'pamela@gmail.com',
        'nininha123',
      ];

      console.log('\nVerificando termos no arquivo de teste...');
      termos.forEach((t) => {
        if (conteudo.includes(t)) {
          console.log(`  ${t} - encontrado`);
        } else {
          console.log(`  ${t} - não encontrado`);
          todosOk = false;
        }
      });
    }
  } else {
    console.log(`${arquivo} - não encontrado`);
    todosOk = false;
  }
});

console.log('\n' + '='.repeat(50));

if (todosOk) {
  console.log('Todos os arquivos estão corretos.');
  console.log('Para executar:');
  console.log('  1) pip install -r requirements.txt');
  console.log('  2) python executar_testes.py');
} else {
  console.log('Alguns arquivos estão faltando ou com problemas.');
  console.log('Verifique os itens listados acima.');
}