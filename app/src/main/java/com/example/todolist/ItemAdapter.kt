package com.example.todolist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_layout.view.*
class ItemAdapter(private val DataList: List<ListItem>, private val listener: OnItemClickListener) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(DataList[position])
    }
    override fun getItemCount(): Int{
       return DataList.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) ,
    View.OnClickListener{
        fun bindItems(@NonNull Items: ListItem) {
            itemView.Date.text = Items.DateStart
            itemView.Task.text = Items.Task
            itemView.Note.text = Items.Note
            itemView.setBackgroundColor(Color.parseColor(Items.Color))
        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}


