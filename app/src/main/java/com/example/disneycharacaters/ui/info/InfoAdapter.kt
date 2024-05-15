package com.example.disneycharacaters.ui.info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.disneycharacaters.R
import com.example.disneycharacaters.data.model.disney_package.DataModel
import com.example.disneycharacaters.databinding.InfoItemBinding

class InfoAdapter(
    private val gameList: List<DataModel?>?,
    val function: (DataModel?) -> Unit
) : RecyclerView.Adapter<InfoAdapter.GameViewHolder>() {

    inner class GameViewHolder(itemView: View): ViewHolder(itemView) {
        val binding = InfoItemBinding.bind(itemView)

        fun updateUI(dataModel: DataModel?) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(dataModel?.imageUrl)
                    .placeholder(R.drawable.baseline_person_24)
                    .into(ivImage2)
                tvId.text = "ID: ${dataModel?.id}"
                tvCreatedAt.text = "Created at: ${dataModel?.createdAt}"
                tvUpdatedAt.text = "Updated at: ${dataModel?.updatedAt}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.info_item, parent, false)
        )
    }

    override fun getItemCount() = gameList!!.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.updateUI(gameList?.get(position))

        holder.binding.root.setOnClickListener {
            function.invoke(gameList?.get(position))
        }
    }
}