package com.mvn1101.shoppinglist.data

import com.mvn1101.shoppinglist.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDBModel(shopItem: ShopItem) = ShopItemDBModel (
            id = shopItem.id,
            name = shopItem.name,
            count = shopItem.count,
            enabled = shopItem.enabled
        )

    fun mapDBModelToEntity(shopItemDBModel: ShopItemDBModel) = ShopItem (
        id = shopItemDBModel.id,
        name = shopItemDBModel.name,
        count = shopItemDBModel.count,
        enabled = shopItemDBModel.enabled
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDBModel>) = list.map{
        mapDBModelToEntity(it)
    }

}