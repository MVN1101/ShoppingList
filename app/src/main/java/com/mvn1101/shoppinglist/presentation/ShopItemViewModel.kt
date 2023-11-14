package com.mvn1101.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvn1101.shoppinglist.data.ShopListRepositoryImpl
import com.mvn1101.shoppinglist.domain.*

class ShopItemViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getItemShopItemUseCase = GetShopItemUseCase(repository)
    private val addItemShopItemUseCase = AddShopItemUseCase(repository)
    private val editItemShopItemUseCase = EditShopItemUseCase(repository)

    private var _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private var _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private var _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem>
        get() = _shopItem

    private var _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
    get() = _shouldCloseScreen

    fun getShopItem(shopItemId: Int) {
        val item = getItemShopItemUseCase.getShopItem(shopItemId)
        _shopItem.value = item
    }

    fun addShopItem(inputName: String?, inputCount: String?) {

        val name = parseName(inputName)
        val count = parseCount(inputCount)
        if (validateInput(name, count)) {
            val shopItem = ShopItem(name, count, true)
            addItemShopItemUseCase.addShopItem(shopItem)
            finishWork()
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        if (validateInput(name, count)) {
            _shopItem.value?.let {
                val item = it.copy(name = name, count = count)
                editItemShopItemUseCase.editShopItem(item)
                finishWork()
            }

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

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (count <= 0) {
            _errorInputCount.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }

    fun resetErrorInputCount() {
        _errorInputCount.value = false
    }

    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }


}