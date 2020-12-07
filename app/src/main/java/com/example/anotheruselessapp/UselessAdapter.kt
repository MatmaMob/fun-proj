package com.example.anotheruselessapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anotheruselessapp.data.entity.Element
import com.example.anotheruselessapp.ui.UselessElementView


class UselessAdapter(
    private val elements: List<Element>,
    private val onElementChecked: (Element) -> Unit,
    private val onElementHold: (Element) -> Unit
) :
    RecyclerView.Adapter<UselessAdapter.UselessViewHolder>() {

    inner class UselessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val uselessElementView by lazy {
            itemView.findViewById<UselessElementView>(R.id.uselessElementView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UselessViewHolder =
        UselessViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_useless, parent, false)
        )

    override fun getItemCount(): Int = elements.size

    override fun getItemViewType(position: Int): Int = position

    override fun onBindViewHolder(holder: UselessViewHolder, position: Int) {
        holder.uselessElementView.setData(
            elements[position].title,
            elements[position].priority,
            elements[position].isDone
        )

        holder.uselessElementView.setBoxListener {
            elements[position].isDone = it
            onElementChecked(elements[position])
            notifyItemChanged(position)
        }

        holder.itemView.setOnLongClickListener {
            onElementHold(elements[position])
            notifyItemRemoved(position)
            false
        }
    }
}