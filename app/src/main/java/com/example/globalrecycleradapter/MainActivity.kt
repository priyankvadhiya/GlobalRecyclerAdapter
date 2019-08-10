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
    var list = arrayListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this


        for (i in 0..9) {
            list.add(ItemModel("ItemTest$i"))
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(mContext)
            hasFixedSize()
            adapter = GlobalRecyclerAdapter(list, R.layout.item_layout, this@MainActivity)
        }
    }

    override fun onRecyclerBind(rowView: View, position: Int) {
        rowView.textView.text = "${list[position].title}"
        rowView.setOnClickListener {
            Toast.makeText(mContext, "$position", Toast.LENGTH_SHORT).show()
        }
    }
}