package com.br.lifecycle.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.lifecycle.data.CounterRepositoryImpl
import com.br.lifecycle.presentation.counter.MainViewModel

/**
 * Fábrica (Factory) para criar instâncias de ViewModels com suas dependências.
 * Esta classe é responsável por instanciar manualmente as classes de ViewModel e fornecer
 * a elas as instâncias de repositório necessárias.
 *
 * Isso é necessário porque o MainViewModel tem uma dependência (repository) em seu construtor.
 */
class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Verifica se a classe de ViewModel solicitada é a MainViewModel
        if (modelClass == MainViewModel::class.java) {
            // Cria e retorna uma instância de MainViewModel, injetando o CounterRepositoryImpl.
            // Esta é uma forma de "Injeção Manual de Dependência".
            return MainViewModel(repository = CounterRepositoryImpl()) as T
        }
        // Se a classe do ViewModel for desconhecida para esta fábrica, lança uma exceção.
        throw IllegalArgumentException("Classe de ViewModel desconhecida: $modelClass")

    }
}