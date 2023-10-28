package com.mvn1101.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>>{
        return shopListRepository.getShopList()
    }
}