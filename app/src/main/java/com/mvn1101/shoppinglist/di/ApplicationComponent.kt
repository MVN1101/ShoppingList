package com.mvn1101.shoppinglist.di

import android.app.Application
import com.mvn1101.shoppinglist.presentation.MainActivity
import com.mvn1101.shoppinglist.presentation.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject (activity: MainActivity)
    fun inject (activity: ShopItemFragment)
    @Component.Factory
    interface Factory {

        fun create (
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}