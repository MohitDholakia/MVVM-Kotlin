package com.md.demo.adapter

import android.app.FragmentTransaction
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.md.demo.R
import com.md.demo.data.model.ResponseBean
import com.md.demo.view.fragment.listdetail.ListDetailFragment
import com.md.demo.view.activity.main.MainActivity
import kotlinx.android.synthetic.main.row_list.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.RecyclerViewAdapterViewHolder>() {

    var dataList: List<ResponseBean> = emptyList<ResponseBean>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_list, parent, false)
        return RecyclerViewAdapterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapterViewHolder, position: Int) {
        val data = dataList[position]
        holder.textViewTitle.text = data.title

        if(data.rating!=null){
            holder.ratingBar.numStars = data.rating!!
        }

        Glide.with(holder.textViewTitle.context)
                .load(data.img.first().image)
                .into(holder.imgLogo)

        holder.itemView.setOnClickListener {
            val fragment = ListDetailFragment()
            val bundle = Bundle()
            bundle.putInt("pos",position)
            fragment.arguments = bundle
            (holder.itemView.context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack("List")
                    .commit()
        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class RecyclerViewAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle = itemView.textViewTitle
        val ratingBar = itemView.ratingBar
        val imgLogo = itemView.imgLogo
    }
}