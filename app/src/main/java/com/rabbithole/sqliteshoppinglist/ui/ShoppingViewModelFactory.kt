package com.rabbithole.sqliteshoppinglist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rabbithole.sqliteshoppinglist.data.repositories.ShoppingRepository
import com.rabbithole.sqliteshoppinglist.ui.shoppinglist.ShoppingViewModel

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private val repository: ShoppingRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}