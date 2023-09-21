package com.example.kt_less17


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyRecyclerViewAdapter(private val items: List<GetResponse>, private val onItemClick: (GetResponse) -> Unit): RecyclerView.Adapter<MyRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val listItemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return MyRecyclerViewHolder(listItemViewHolder)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.name
        Glide.with(holder.itemView)
            .load(items[position].images.sm)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

    }
}


class MyRecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.title)
    val image: ImageView = itemView.findViewById(R.id.image)
}
