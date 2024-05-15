package com.example.virginmoney.ui.disney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.disneycharacaters.R
import com.example.disneycharacaters.data.model.disney.DataModel
import com.example.disneycharacaters.data.model.disney.DisneyCharactersModel
import com.example.disneycharacaters.databinding.ItemDisneyBinding


class DisneyAdapter(
    val disneyList: List<DataModel?>?,
    val function: (DataModel?) -> Unit
) : Adapter<DisneyAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding = ItemDisneyBinding.bind(itemView)

        fun updateUI(dataModel: DataModel?) {
            // handle the ui changes based on current data
            binding.apply {
                Glide.with(itemView.context).load(dataModel?.imageUrl)
                    .placeholder(R.drawable.people_icon)
                    .into(ivDisney)
                tvDisneyName.text = "${dataModel?.name}"



            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_disney, parent, false)
        )
    }

    override fun getItemCount() = disneyList!!.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateUI(disneyList?.get(position))

        holder.binding.root.setOnClickListener {
            function.invoke(disneyList?.get(position))
        }
    }
}