package com.adisastrawan.mysubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.adisastrawan.mysubmission.databinding.ItemRowChampBinding

class ListChampionAdapter(private val listChampion:ArrayList<Champion>):RecyclerView.Adapter<ListChampionAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowChampBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ListViewHolder(binding)
    }

    override fun getItemCount():Int = listChampion.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,description,photo) = listChampion[position]
        holder.binding.imgChamp.setImageResource(photo)
        holder.binding.tvChampName.text = name
        holder.binding.tvChampDesc.text = description
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_CHAMPION,listChampion[holder.adapterPosition])
            holder.itemView.context.startActivity(intent)
        }
    }
    class ListViewHolder( var binding:ItemRowChampBinding) : RecyclerView.ViewHolder(binding.root)
}