package com.otamurod.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.otamurod.cleanarchitecture.App
import com.otamurod.cleanarchitecture.databinding.ActivityMainBinding
import com.otamurod.cleanarchitecture.vm.UserResource
import com.otamurod.cleanarchitecture.vm.UserViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.applicationComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.getUsersFlow()
                .collectLatest {
                    when (it) {
                        is UserResource.Error -> {
                            Log.d("TAG", "onCreate: ${it.message}")
                        }
                        is UserResource.Loading -> {
                            Log.d("TAG", "onCreate: $it")
                        }
                        is UserResource.Success -> {
                            Log.d("TAG", "onCreate: ${it.list}")
                        }
                    }
                }
        }
    }
}