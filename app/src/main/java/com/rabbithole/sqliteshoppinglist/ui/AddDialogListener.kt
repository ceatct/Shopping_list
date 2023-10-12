package com.rabbithole.sqliteshoppinglist.ui

import com.rabbithole.sqliteshoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}