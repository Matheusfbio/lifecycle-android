# 📝 Resumo do Projeto: Lifecycle Counter App

Este projeto é um exemplo prático de uma aplicação Android que implementa a **arquitetura MVVM (Model-View-ViewModel)** com navegação entre fragments, `LiveData`, `ViewModel` e `Repository`. O objetivo é demonstrar padrões modernos de desenvolvimento Android, como separação de responsabilidades, testabilidade e escalabilidade.

---

## 🚀 Principais Funcionalidades

- **Contador Compartilhado**: Um contador é mantido em um `ViewModel` e compartilhado entre dois fragments (`FirstFragment` e `SecondFragment`).
- **Navegação entre Fragments**: Uso do **Navigation Component** para navegar entre os fragments.
- **Atualização Automática da UI**: `LiveData` observa o contador e atualiza a interface automaticamente.
- **Testes Unitários e Instrumentados**: Exemplos de testes para validar a lógica e a aplicação.

---

## 🧠 Arquitetura MVVM

### 1. **Model (Modelo de Dados)**
- **`CounterRepository.kt`**: Interface que define operações para o contador.
- **`CounterRepositoryImpl.kt`**: Implementação do repositório, usando `LiveData` para armazenar o valor do contador.

### 2. **ViewModel**
- **`MainViewModel.kt`**:
    - Exibe o contador como `LiveData`.
    - Fornece métodos para incrementar o contador.
    - Compartilhado entre fragments via `activityViewModels`.

### 3. **View**
- **`MainActivity.kt`**:
    - Configura a navegação e a ActionBar.
    - Usa `ViewModelFactory` para injetar o `MainViewModel`.
- **`FirstFragment.kt`**:
    - Navega para `SecondFragment` ao clicar no botão.
- **`SecondFragment.kt`**:
    - Observa o contador do `ViewModel` e atualiza a UI.
    - Incrementa o contador ao clicar no botão.

---

## 🔧 Componentes Principais

### 1. **ViewModelFactory**
- **`ViewModelFactory.kt`**:
    - Cria instâncias de `MainViewModel` com dependências injetadas (`CounterRepositoryImpl`).
    - Permite que o `ViewModel` seja compartilhado entre fragments.

### 2. **Navigation Component**
- **`MainActivity.kt`**:
    - Usa `NavController` para gerenciar a navegação entre fragments.
    - Sincroniza a AppBar com o NavController via `AppBarConfiguration`.

### 3. **ViewBinding**
- Substitui `findViewById` para acesso seguro às views.
- Exemplo: `ActivityMainBinding` em `MainActivity`.

### 4. **LiveData e Observability**
- O contador é observado via `LiveData` nos fragments.
- Atualizações automáticas da UI quando o valor do contador muda.

---

## 🧪 Testes

### 1. **Testes Unitários**
- **`ExampleUnitTest.kt`**:
    - Testa lógica simples (ex.: `2 + 2`).
    - Executado na máquina de desenvolvimento.

### 2. **Testes Instrumentados**
- **`ExampleInstrumentedTest.kt`**:
    - Verifica o contexto da aplicação em um dispositivo real.
    - Executado em um dispositivo ou emulador.

---

## 🛠️ Como Executar

1. **Clonar o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/lifecycle-counter.git
   ```
2. **Abrir no Android Studio**.
3. **Executar o projeto** no emulador ou dispositivo físico.

---

## ✅ Benefícios da Arquitetura

- **Separação de responsabilidades**: Cada camada (Model, View, ViewModel) tem uma única responsabilidade.
- **Testabilidade**: O uso de interfaces e injeção de dependências facilita testes unitários.
- **Manutenibilidade**: Código limpo e modular, fácil de estender.
- **Escalabilidade**: Estrutura preparada para adicionar novos recursos.

---

## 📌 Conclusão

Este projeto demonstra uma arquitetura moderna para aplicativos Android, com foco em **MVVM**, **navegação entre fragments**, e **observabilidade de dados via LiveData**. A estrutura permite que o código seja **testável**, **manutenível** e **escalável** para futuras funcionalidades.