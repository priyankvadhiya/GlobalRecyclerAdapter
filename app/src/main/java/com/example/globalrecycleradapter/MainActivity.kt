package com.example.globalrecycleradapter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MainActivity : AppCompatActivity(), GlobalRecyclerAdapter.OnRecyclerBindListener {

    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this

        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(mContext)
            hasFixedSize()
            adapter = GlobalRecyclerAdapter(list, R.layout.item_layout, this@MainActivity)
        }
    }

    override fun onRecyclerBind(rowView: View, position: Int) {
        rowView.textView.text = "Item$position"
        rowView.setOnClickListener {
            Toast.makeText(mContext, "$position", Toast.LENGTH_SHORT).show()
        }
    }
}