package com.example.examprojectapp.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.HomeModel2
import com.example.examprojectapp.databinding.ItemHome2Binding

class ExamAdapter(val onClick:(HomeModel2)->Unit): ListAdapter<HomeModel2, ExamAdapter.ViewHolder>(ExamDiff()) {


    inner class ViewHolder(private val binding: ItemHome2Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel2) {
            binding.tvLatsQuiz.text = model.title
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgItem)

            Glide.with(binding.root)
                .load(model.imgCheck)
                .into(binding.imgCheck)

            itemView.setOnClickListener {
                onClick(model)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHome2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ExamDiff: DiffUtil.ItemCallback<HomeModel2>() {
    override fun areItemsTheSame(oldItem: HomeModel2, newItem: HomeModel2): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeModel2, newItem: HomeModel2): Boolean {
        return oldItem == newItem
    }

}