package com.example.examprojectapp.fragments.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.TestResult
import com.example.examprojectapp.R

class CompletedTestsAdapter() : ListAdapter<TestResult, CompletedTestsAdapter.ViewHolder>(YourDiffCallback()) {

    private var itemCount45 = 0

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberTextView: TextView = itemView.findViewById(R.id.tv_number)
        val itemImageView: ImageView = itemView.findViewById(R.id.img_item)
        val testNameTextView: TextView = itemView.findViewById(R.id.tv_lats_quiz)
        val checkImageView: ImageView = itemView.findViewById(R.id.img_check)

        fun bindCounter(counter: Int) {
            numberTextView.text = counter.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_stat, parent, false)
        val viewHolder = ViewHolder(view)

        viewHolder.bindCounter(++itemCount45)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val completedTest = getItem(position)

        holder.testNameTextView.text = completedTest.testName
    }
}

class YourDiffCallback : DiffUtil.ItemCallback<TestResult>() {
    override fun areItemsTheSame(oldItem: TestResult, newItem: TestResult): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TestResult, newItem: TestResult): Boolean {
        return oldItem == newItem
    }
}