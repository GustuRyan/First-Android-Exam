package com.example.myapplication

import com.example.myapplication.DetailActivity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFurnitureAdapter(private val listFurnitures: ArrayList<Furnitures>) : RecyclerView.Adapter<ListFurnitureAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, category, price, photo) = listFurnitures[position]
        if (photo != null) {
            holder.imgPhoto.setImageResource(photo)
        }
        holder.tvName.text = name
        holder.tvPrice.text = price
        holder.tvCategory.text = category
        holder.tvDescription.text = description.toString()

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("EXTRA_FURNITURE", listFurnitures[position])  // Passing object Furniture
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = listFurnitures.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        val tvCategory: TextView = itemView.findViewById(R.id.tv_item_category)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}