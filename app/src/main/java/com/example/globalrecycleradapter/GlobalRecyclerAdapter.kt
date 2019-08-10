package com.example.globalrecycleradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GlobalRecyclerAdapter(
    private val list: List<Any>,
    private val xmlLayout: Int,
    private val onRecyclerBindListener: OnRecyclerBindListener
) :
    RecyclerView.Adapter<GlobalRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(xmlLayout, parent, false)
        return MyViewHolder(rowView)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Do you Write
        val rowView = holder.rowView
        onRecyclerBindListener.onRecyclerBind(rowView, position)
    }

    class MyViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)

    interface OnRecyclerBindListener {
        fun onRecyclerBind(rowView: View, position: Int)
    }
}