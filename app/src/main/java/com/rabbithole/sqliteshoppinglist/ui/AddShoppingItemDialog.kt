package com.rabbithole.sqliteshoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.rabbithole.sqliteshoppinglist.data.db.entities.ShoppingItem
import com.rabbithole.sqliteshoppinglist.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString().toInt()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Пожалуйста, введите имя", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}
