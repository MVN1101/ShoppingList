package com.mvn1101.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem (shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}