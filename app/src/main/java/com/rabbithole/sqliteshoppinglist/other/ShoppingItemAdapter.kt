package com.rabbithole.sqliteshoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rabbithole.sqliteshoppinglist.R
import com.rabbithole.sqliteshoppinglist.data.db.entities.ShoppingItem
import com.rabbithole.sqliteshoppinglist.databinding.ShoppingItemBinding
import com.rabbithole.sqliteshoppinglist.ui.shoppinglist.ShoppingViewModel


class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.binding.tvName.text = curShoppingItem.name
        holder.binding.tvAmount.text = "${curShoppingItem.amount}"

        holder.binding.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.binding.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.binding.ivMinus.setOnClickListener {
            if(curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }
    }


    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ShoppingItemBinding.bind(itemView)
    }

}