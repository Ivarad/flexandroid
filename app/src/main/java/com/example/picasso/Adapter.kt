package com.example.picasso

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class Adapter (var items : List<ItemOfList>) : RecyclerView.Adapter<com.example.picasso.Adapter.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val img = itemView.findViewById<ImageView>(R.id._image)

        fun bind(item : ItemOfList)
        {
            Picasso.get().load(item.urlstring).fit().placeholder(R.drawable.flexblack).error(R.drawable.flexblack).into(img)
        }

    }
}

