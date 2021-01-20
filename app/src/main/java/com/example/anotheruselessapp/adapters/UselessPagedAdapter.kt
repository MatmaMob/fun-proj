package com.example.anotheruselessapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.anotheruselessapp.R
import com.example.anotheruselessapp.data.entity.Element
import com.example.anotheruselessapp.ui.UselessElementView

class UselessPagedAdapter(
    private val onElementChecked: (Element) -> Unit,
    private val onElementHold: (Element) -> Unit
) :
    PagedListAdapter<Element, UselessPagedAdapter.UselessViewHolder>(DIFF_CALLBACK) {

    inner class UselessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val uselessElementView by lazy {
            itemView.findViewById<UselessElementView>(R.id.uselessElementView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UselessViewHolder =
        UselessViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_useless, parent, false)
        )

    override fun onBindViewHolder(holder: UselessViewHolder, position: Int) {

        val element: Element? = getItem(position)

        element?.let { e ->
            holder.uselessElementView.setData(
                e.title,
                e.priority,
                e.isDone
            )

            holder.uselessElementView.setBoxListener {
                e.isDone = it
                onElementChecked(e)
            }

            holder.itemView.setOnLongClickListener {
                onElementHold(e)
                false
            }
        }
    }

    override fun getItemViewType(position: Int): Int = position

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Element>() {
            override fun areItemsTheSame(oldItem: Element, newItem: Element): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Element, newItem: Element): Boolean =
                oldItem == newItem
        }
    }
}