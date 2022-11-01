package com.gauravbora.swipetorefresh

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
   private lateinit var  swipe: SwipeRefreshLayout
private  var count=11

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.items)
        swipe = findViewById(R.id.swipe)
        val itemObject: MutableList<Items> = mutableListOf()
        itemObject.add(Items("Item1", "Description1"))
        itemObject.add(Items("Item2", "Description2"))
        itemObject.add(Items("Item3", "Description3"))
        itemObject.add(Items("Item4", "Description4"))
        itemObject.add(Items("Item5", "Description5"))
        itemObject.add(Items("Item6", "Description6"))
        itemObject.add(Items("Item7", "Description7"))
        itemObject.add(Items("Item8", "Description8"))
        itemObject.add(Items("Item9", "Description9"))
        itemObject.add(Items("Item10", "Description10"))


        swipe.setOnRefreshListener {
            Toast.makeText(this, "Refreshed", Toast.LENGTH_SHORT).show()
            for (int in 0..9) {
                itemObject.add(Items("Item$count", "Description$count"))
                count++
            }
            val adapter = Adapter(itemObject)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

            swipe.isRefreshing = false
        }

        val adapter = Adapter(itemObject)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}

