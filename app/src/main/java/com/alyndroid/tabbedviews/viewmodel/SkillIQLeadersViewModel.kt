package com.alyndroid.tabbedviews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alyndroid.tabbedviews.model.SkillIQLeadersRespDao
import com.alyndroid.tabbedviews.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SkillIQLeadersViewModel(application: Application) : AndroidViewModel(application) {
    private var appContext: Application = application

    fun getSkillIQLeaders(): LiveData<List<SkillIQLeadersRespDao>> {
        var response = MutableLiveData<List<SkillIQLeadersRespDao>>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val list: List<SkillIQLeadersRespDao> = Repository().getSkillIQLeaders()
                response.postValue(list)
            }
        }
        return response
    }
}