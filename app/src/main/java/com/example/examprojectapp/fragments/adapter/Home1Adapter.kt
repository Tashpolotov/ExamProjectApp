package com.example.examprojectapp.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.HomeModel1
import com.example.examprojectapp.databinding.ItemHome1Binding

class Home1Adapter(val onClick:(HomeModel1)->Unit):ListAdapter<HomeModel1, Home1Adapter.ViewHolder>(HomeDiff()) {


    inner class ViewHolder(private val binding:ItemHome1Binding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel1) {
            binding.tvName.text = model.title
            binding.tvTime.text = model.time
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgAll)

            itemView.setOnClickListener {
                onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHome1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeDiff:DiffUtil.ItemCallback<HomeModel1>() {
    override fun areItemsTheSame(oldItem: HomeModel1, newItem: HomeModel1): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeModel1, newItem: HomeModel1): Boolean {
        return oldItem == newItem
    }

}
