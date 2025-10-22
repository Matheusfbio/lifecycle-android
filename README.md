# Android ViewModel: Sobrevivendo a Mudanças de Configuração

Este projeto é uma demonstração simples, porém fundamental, do componente `ViewModel` da biblioteca Android Jetpack. O objetivo é ilustrar a principal vantagem do `ViewModel`: **preservar o estado da interface do usuário (UI) durante mudanças de configuração**, como a rotação da tela.

## O Problema que o ViewModel Resolve

No Android, sempre que uma "mudança de configuração" ocorre (a mais comum sendo a rotação do dispositivo), o sistema destrói e recria a `Activity` ou o `Fragment` atual. 

Isso causa um problema sério: qualquer dado que estava armazenado em variáveis de instância dentro da sua `Activity` será perdido. No contexto deste projeto, se o nosso contador (`counter`) fosse uma variável dentro da `MainActivity`, ele seria resetado para `0` toda vez que o usuário girasse o celular.

Isso leva a uma experiência de usuário ruim e a bugs difíceis de gerenciar.

## A Solução: `ViewModel`

O `ViewModel` é uma classe projetada para armazenar e gerenciar dados relacionados à UI de forma consciente do ciclo de vida. A sua principal característica é que **um `ViewModel` sobrevive à destruição e recriação da sua `Activity` ou `Fragment`**.

**Como funciona:**

1.  A `Activity` solicita uma instância do `ViewModel`.
2.  O `ViewModel` é criado e seu escopo (tempo de vida) é atrelado ao da `Activity`.
3.  Quando o usuário rotaciona a tela, a `Activity` é destruída, mas o `ViewModel` associado a ela continua em memória.
4.  Quando a `Activity` é recriada, ela solicita um `ViewModel` novamente e recebe a **mesma instância** que já existia, com todos os seus dados intactos.
5.  O `ViewModel` só é finalmente destruído quando sua `Activity` é finalizada de vez (por exemplo, quando o usuário aperta o botão "voltar").

### `MainViewModel` neste Projeto

O código em `MainViewModel.kt` é um exemplo minimalista dessa arquitetura:

```kotlin
package com.br.lifecycle

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
     var counter = 0
          private set

     fun increment(){
          counter++
     }
}
```

-   A classe herda de `ViewModel`.
-   A variável `counter` guarda o estado (o número atual).
-   O método `increment()` modifica o estado.

Ao manter o `counter` dentro do `ViewModel` em vez da `Activity`, garantimos que seu valor seja preservado, não importa quantas vezes o usuário gire o dispositivo.

## Como Executar a Demonstração

1.  Clone este repositório e abra no Android Studio.
2.  Execute o aplicativo em um emulador ou dispositivo físico.
3.  Clique no botão para incrementar o contador algumas vezes.
4.  Rotacione o dispositivo.
5.  **Observe que o valor do contador permaneceu o mesmo!**

## Conclusão

Usar o `ViewModel` é uma prática essencial na arquitetura de aplicativos Android modernos porque:

-   **Evita a perda de dados:** Mantém o estado da UI durante mudanças de configuração.
-   **Separa responsabilidades:** Move a lógica de dados da UI para fora das `Activities` e `Fragments`, tornando-os mais leves e fáceis de testar.
-   **É consciente do ciclo de vida:** Garante que os dados sejam gerenciados de forma correta, evitando memory leaks.
