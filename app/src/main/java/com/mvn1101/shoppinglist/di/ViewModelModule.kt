package com.mvn1101.shoppinglist.di

import androidx.lifecycle.ViewModel
import com.mvn1101.shoppinglist.presentation.MainViewModel
import com.mvn1101.shoppinglist.presentation.ShopItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel (viewModel: MainViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    fun bindShopItemViewModel (viewModel: ShopItemViewModel):ViewModel
}