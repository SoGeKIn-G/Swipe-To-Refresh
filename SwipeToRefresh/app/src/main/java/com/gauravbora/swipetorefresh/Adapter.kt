
package com.gauravbora.swipetorefresh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val items:List<Items>): RecyclerView.Adapter<Adapter.MyViewHoder>() {

//    creates view holder in which we stores views
//    layout inflater converts layout xml file to java code

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.items_view,parent,false)
        return MyViewHoder(view)
    }

    override fun onBindViewHolder(holder: MyViewHoder, position: Int) {
        holder.title.text=items[position].title
        holder.discription.text=items[position].description
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class MyViewHoder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val title=itemView.findViewById<TextView>(R.id.tittle)
        val discription=itemView.findViewById<TextView>(R.id.description)

    }
}