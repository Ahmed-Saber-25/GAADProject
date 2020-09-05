package com.alyndroid.tabbedviews.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alyndroid.tabbedviews.R
import com.alyndroid.tabbedviews.model.SkillIQLeadersRespDao
import com.alyndroid.tabbedviews.view.adapters.SkillIQLeadersAdapter
import com.alyndroid.tabbedviews.viewmodel.SkillIQLeadersViewModel
import kotlinx.android.synthetic.main.fragment_skill_iq_leaders.*


class SkillIQLeadersFragment : Fragment() {

    private lateinit var skillIQLeadersViewModel: SkillIQLeadersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        skillIQLeadersViewModel = ViewModelProviders.of(this)[SkillIQLeadersViewModel::class.java]
        skillIQLeadersViewModel.getSkillIQLeaders().observe(
            this,
            Observer {
                setupView(it)
            })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false)
    }

    private fun setupView(list: List<SkillIQLeadersRespDao>) {
        val layout = LinearLayoutManager(context)
        iqLeadersRecyclerView.layoutManager = layout
        iqLeadersRecyclerView.adapter = SkillIQLeadersAdapter(list)
    }

}