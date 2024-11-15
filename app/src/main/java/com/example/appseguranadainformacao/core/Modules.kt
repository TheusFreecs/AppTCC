package com.example.appseguranadainformacao.core

import com.example.appseguranadainformacao.home.AppViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
     viewModel { AppViewModel(androidApplication()) }
}


