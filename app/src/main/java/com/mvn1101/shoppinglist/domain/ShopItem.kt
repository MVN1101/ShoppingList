package com.mvn1101.shoppinglist.domain

data class ShopItem (
    val name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object{
        const val UNDEFINED_ID = 0
    }
}


