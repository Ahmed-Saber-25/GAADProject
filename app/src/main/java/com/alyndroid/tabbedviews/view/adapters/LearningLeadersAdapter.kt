package com.alyndroid.tabbedviews.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alyndroid.tabbedviews.R
import com.alyndroid.tabbedviews.model.LearningLeadersRespDao
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.learning_leader_card.view.*

class LearningLeadersAdapter(private val list: List<LearningLeadersRespDao>) :
    RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.learning_leader_card, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.leader_name.text = list[position].name
        holder.itemView.learning_hours_and_country_name.text =
            list[position].hours.toString() + "  Learning Hours , " + list[position].country

        Glide.with(holder.itemView.context)
            .load(list[position].badgeUrl)
            .placeholder(R.drawable.top_learner)
            .thumbnail(0.5f)
            .into(holder.itemView.badge_img)

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}