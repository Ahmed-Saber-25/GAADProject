package com.alyndroid.tabbedviews.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alyndroid.tabbedviews.R
import com.alyndroid.tabbedviews.model.SkillIQLeadersRespDao
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.skill_iq_leader_card.view.*

class SkillIQLeadersAdapter(private val list: List<SkillIQLeadersRespDao>) :
    RecyclerView.Adapter<SkillIQLeadersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.skill_iq_leader_card, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.iq_leader_name.text = list[position].name
        holder.itemView.iq_score_and_country_name.text =
            list[position].score.toString() + "  Skill IQ Score , " + list[position].country

        Glide.with(holder.itemView.context)
            .load(list[position].badgeUrl)
            .placeholder(R.drawable.skill_iq)
            .thumbnail(0.5f)
            .into(holder.itemView.iq_badge_img)

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}