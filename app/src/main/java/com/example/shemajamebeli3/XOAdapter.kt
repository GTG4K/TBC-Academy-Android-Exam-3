package com.example.shemajamebeli3

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli3.databinding.XoItemBinding

class XOAdapter : RecyclerView.Adapter<XOAdapter.XOViewHolder>() {

    private var onXOClickListener: ((XO) -> Unit)? = null
    private var xPlayer = true

    inner class XOViewHolder(private val binding: XoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: XO) {
            binding.btnXO.setOnClickListener {
                onXOClickListener?.invoke(item)
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