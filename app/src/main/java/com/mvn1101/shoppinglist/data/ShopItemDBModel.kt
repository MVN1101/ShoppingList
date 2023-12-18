package com.mvn1101.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mvn1101.shoppinglist.domain.ShopItem

@Entity (tableName = "Shop_items")
data class ShopItemDBModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val count: Int,
    var enabled: Boolean
)