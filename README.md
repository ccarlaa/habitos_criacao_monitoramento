# Hábitos - Criação e Monitoramento

Projeto da disciplina de Orientação a Objetos da Universidade de Brasília.

A aplicação consiste em um sistema para que um usuário consiga realizar o monitoramento de seus hábitos.

## Como executar o projeto

### Pré-requisitos
- Java JDK 8 ou superior instalado
- Terminal/Prompt de comando

### Compilação
No diretório raiz do projeto, execute:

```bash
javac -d bin src/modelo/*.java src/controle/*.java src/view/*.java
```

### Execução
Após compilar, execute:

```bash
java -cp bin view.TelaCriacaoConta
```

A aplicação abrirá uma interface gráfica onde você poderá:
1. Criar uma conta de usuário
2. Fazer login
3. Gerenciar seus hábitos (criar, editar, monitorar)

## Estrutura do Projeto

- `src/modelo/` - Classes de modelo (Usuario, Habito, etc.)
- `src/controle/` - Classes de controle da aplicação
- `src/view/` - Interface gráfica (Swing)
- `src/teste/` - Testes unitários (requer JUnit)
- `doc/` - Documentação JavaDoc
- `bin/` - Classes compiladas

## Funcionalidades

- Cadastro e login de usuários
- Criação de hábitos mensuráveis (com metas numéricas)
- Criação de hábitos sim/não
- Monitoramento e acompanhamento de hábitos
- Interface gráfica intuitiva