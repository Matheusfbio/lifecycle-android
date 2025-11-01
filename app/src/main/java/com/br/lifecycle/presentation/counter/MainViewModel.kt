package com.br.lifecycle.presentation.counter

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.br.lifecycle.R
import com.br.lifecycle.databinding.ActivityMainBinding
import com.br.lifecycle.domain.CounterRepository

class MainViewModel(
    private val repository: CounterRepository
): ViewModel() {
    val counter: LiveData<Int> = repository.getCounter()

    var incrementBy = 1

     fun increment(){
         repository.incrementCounterBy(incrementBy)

     }
}

//class NumberLiveData(initial: Int = 0): MutableLiveData<Int>(initial) {
//     override fun onActive() {
//          super.onActive()
//          Log.d("MainViewModel", "onActive")
//     }
//
//     override fun onInactive() {
//          super.onInactive()
//          Log.d("MainViewModel", "onInactive")
//     }
//
//}

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController: NavController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


        binding.fab.setOnClickListener { view ->
            viewModel.increment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }
}