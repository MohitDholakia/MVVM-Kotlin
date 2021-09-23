package com.md.demo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri.parse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.md.demo.R
import com.md.demo.data.model.UserResult
import com.md.demo.view.activity.main.MainActivity
import com.md.demo.view.fragment.listdetail.ListDetailFragment
import kotlinx.android.synthetic.main.row_list.view.*
import java.util.*


class ListAdapter :
        RecyclerView.Adapter<ListAdapter.RecyclerViewAdapterViewHolder>() {

    var dataList: List<UserResult> = emptyList<UserResult>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RecyclerViewAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_list, parent, false)
        return RecyclerViewAdapterViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerViewAdapterViewHolder, position: Int) {
        val data = dataList[position]
        holder.txtTitle.text = """${data.name.title} ${data.name.first} ${data.name.last}"""

        Glide.with(holder.txtTitle.context)
                .load(data.picture.thumbnail)
                .into(holder.imgLogo)

        holder.llLabels.setOnClickListener {
            (holder.itemView.context as MainActivity).supportFragmentManager.beginTransaction()
                    .add(R.id.container, ListDetailFragment.newInstance(data)!!)
                    .addToBackStack("List")
                    .commit()
        }

        holder.imgLocation.setOnClickListener {
            loadMap(it.context, data)
        }
    }

    private fun loadMap(context: Context, data: UserResult) {
        val uri: String = java.lang.String.format(
                Locale.ENGLISH,
                "geo:%s,%s",
                data.location.coordinates.latitude,
                data.location.coordinates.longitude
        )
        val intent = Intent(Intent.ACTION_VIEW, parse(uri))
        (context as MainActivity).startActivity(intent)
    }

    override fun getItemCount(): Int = dataList.size

    inner class RecyclerViewAdapterViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.textViewTitle
        val llLabels: LinearLayout = itemView.llLabels
        val imgLogo: RoundedImageView = itemView.imgLogo
        val imgLocation: RoundedImageView = itemView.imgLocation
    }
}