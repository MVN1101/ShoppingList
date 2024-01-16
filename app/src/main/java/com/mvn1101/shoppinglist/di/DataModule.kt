package com.mvn1101.shoppinglist.di

import android.app.Application
import com.mvn1101.shoppinglist.data.AppDataBase
import com.mvn1101.shoppinglist.data.ShopListDao
import com.mvn1101.shoppinglist.data.ShopListRepositoryImpl
import com.mvn1101.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl:ShopListRepositoryImpl): ShopListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideShopDao(
            application: Application
        ):ShopListDao {
            return AppDataBase.getInstance(application).shopListDao()
        }
    }
}