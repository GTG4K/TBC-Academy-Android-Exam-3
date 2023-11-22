package com.example.shemajamebeli3

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli3.databinding.XoItemBinding

class XOAdapter : RecyclerView.Adapter<XOAdapter.XOViewHolder>() {

    private var xPlayer = true

    inner class XOViewHolder(private val binding: XoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: XO) {
            if (item.selected) {
                when (item.xPlayer) {
                    true -> binding.btnXO.text = "X"
                    false -> binding.btnXO.text = "O"
                    else -> binding.btnXO.text = ""
                }
            }

            binding.btnXO.setOnClickListener {
                if (!item.selected) {
                    item.selected = true
                    if (xPlayer) {
                        binding.btnXO.text = "X"
                        xPlayer = !xPlayer
                    } else {
                        binding.btnXO.text = "O"
                        xPlayer = !xPlayer
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): XOViewHolder {
        val binding = XoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return XOViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: XOViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    private inner class DiffCallback : DiffUtil.ItemCallback<XO>() {

        override fun areItemsTheSame(oldItem: XO, newItem: XO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: XO, newItem: XO): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, DiffCallback())
}