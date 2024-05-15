package com.example.disneycharacaters.ui.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.disneycharacaters.R
import com.example.disneycharacaters.data.model.disney_package.DataModel
import com.example.disneycharacaters.databinding.CharacterItemBinding

class CharacterAdapter(
    private val characterList: List<DataModel?>?,
    val function: (DataModel?) -> Unit
):  RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(itemView: View): ViewHolder(itemView) {
        val binding = CharacterItemBinding.bind(itemView)

        fun updateUI(dataModel: DataModel?) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(dataModel?.imageUrl)
                    .placeholder(R.drawable.baseline_person_24)
                    .into(ivImage)
                tvName.text = "Name: ${dataModel?.name}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        )
    }

    override fun getItemCount() = characterList!!.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.updateUI(characterList?.get(position))

        holder.binding.root.setOnClickListener {
            function.invoke(characterList?.get(position))
        }
    }
}