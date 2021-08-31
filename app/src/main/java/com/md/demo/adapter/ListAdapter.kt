package com.md.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.md.demo.R
import com.md.demo.data.model.ResponseBean
import com.md.demo.view.fragment.list.ListFragmentDirections
import kotlinx.android.synthetic.main.row_list.view.*

class ListAdapter(var fragment: Fragment) : RecyclerView.Adapter<ListAdapter.RecyclerViewAdapterViewHolder>() {

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

        if (data.rating != null) {
            holder.ratingBar.numStars = data.rating!!
        }

        Glide.with(holder.textViewTitle.context)
                .load(data.img.first().image)
                .into(holder.imgLogo)

        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListToDetail(data)
            fragment.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class RecyclerViewAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle = itemView.textViewTitle
        val ratingBar = itemView.ratingBar
        val imgLogo = itemView.imgLogo
    }
}