package com.md.demo.adapter

import android.content.Intent
import android.net.Uri.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.md.demo.R
import com.md.demo.data.model.UserResult
import com.md.demo.view.activity.main.MainActivity
import com.md.demo.view.fragment.listdetail.ListDetailFragment
import kotlinx.android.synthetic.main.row_list.view.*
import java.util.*


class ListAdapter(var fragment : Fragment) :
        RecyclerView.Adapter<ListAdapter.RecyclerViewAdapterViewHolder>() {

        var dataList : List<UserResult> = emptyList<UserResult>().toMutableList()
                set(value) {
                        field = value
                        notifyDataSetChanged()
                }

        override fun onCreateViewHolder(
                parent : ViewGroup,
                viewType : Int
        ) : RecyclerViewAdapterViewHolder {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.row_list, parent, false)
                return RecyclerViewAdapterViewHolder(itemView)
        }

        override fun onBindViewHolder(holder : RecyclerViewAdapterViewHolder, position : Int) {
                val data = dataList[position]
                holder.textViewTitle.text = data.name.title

                Glide.with(holder.textViewTitle.context)
                        .load(data.picture.thumbnail)
                        .into(holder.imgLogo)

                holder.llLabels.setOnClickListener {
                        val fragment = ListDetailFragment()
                        val bundle = Bundle()
                        bundle.putParcelable("modelClass", data)
                        fragment.arguments = bundle
                        (holder.itemView.context as MainActivity).supportFragmentManager.beginTransaction()
                                .add(R.id.container, fragment)
                                .addToBackStack("List")
                                .commit()
                }

                holder.imgLocation.setOnClickListener {
                        val uri : String = java.lang.String.format(
                                Locale.ENGLISH,
                                "geo:%s,%s",
                                data.location.coordinates.latitude,
                                data.location.coordinates.longitude
                        )
                        val intent = Intent(Intent.ACTION_VIEW, parse(uri))
                        (holder.itemView.context as MainActivity).startActivity(intent)
                }
        }

        override fun getItemCount() : Int = dataList.size

        inner class RecyclerViewAdapterViewHolder(itemView : View) :
                RecyclerView.ViewHolder(itemView) {
                val textViewTitle = itemView.textViewTitle
                val llLabels = itemView.llLabels
                val imgLogo = itemView.imgLogo
                val imgLocation = itemView.imgLocation
        }
}