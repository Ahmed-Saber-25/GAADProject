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
import com.alyndroid.tabbedviews.model.LearningLeadersRespDao
import com.alyndroid.tabbedviews.view.adapters.LearningLeadersAdapter
import com.alyndroid.tabbedviews.viewmodel.LearningLeadersViewModel
import kotlinx.android.synthetic.main.fragment_learning_leaders.*

class LearningLeadersFragment : Fragment() {
    private lateinit var learningLeadersViewModel: LearningLeadersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        learningLeadersViewModel = ViewModelProviders.of(this)[LearningLeadersViewModel::class.java]
        learningLeadersViewModel.getLearningLeaders().observe(
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
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false)
    }

    private fun setupView(list: List<LearningLeadersRespDao>) {
        val layout = LinearLayoutManager(context)
        learningLeadersRecyclerView.layoutManager = layout
        learningLeadersRecyclerView.adapter = LearningLeadersAdapter(list)
    }

}