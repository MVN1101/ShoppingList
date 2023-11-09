package com.mvn1101.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.mvn1101.shoppinglist.data.ShopListRepositoryImpl
import com.mvn1101.shoppinglist.domain.*

class ShopItemViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getItemShopItemUseCase = GetShopItemUseCase(repository)
    private val addItemShopItemUseCase = AddShopItemUseCase(repository)
    private val editItemShopItemUseCase = EditShopItemUseCase(repository)

    fun getShopItem(shopItemId: Int) {
        val item = getItemShopItemUseCase.getShopItem(shopItemId)
    }

    fun addShopItem(inputName: String?, inputCount: String?) {

        val name = parseName(inputName)
        val count = parseCount(inputCount)
        if (validateInput(name,count)) {
            val shopItem = ShopItem(name, count,true)
            addItemShopItemUseCase.addShopItem(shopItem)
        }

    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        if (validateInput(name,count)) {
            val shopItem = ShopItem(name, count,true)
            editItemShopItemUseCase.editShopItem(shopItem)
        }

    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: java.lang.Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int):Boolean {
        var result = true
        if (name.isBlank()) {
//            TODO: show error input name
            result = false
        }
        if (count <= 0) {
//            TODO: show error input count
            result = false
        }
        return result
    }


}