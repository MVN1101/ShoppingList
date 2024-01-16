package com.mvn1101.shoppinglist.presentation

import android.app.Application
import com.mvn1101.shoppinglist.di.DaggerApplicationComponent

class ShopApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}