package com.alyndroid.tabbedviews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alyndroid.tabbedviews.model.LearningLeadersRespDao
import com.alyndroid.tabbedviews.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LearningLeadersViewModel(application: Application) : AndroidViewModel(application) {
    private var appContext: Application = application

    fun getLearningLeaders(): LiveData<List<LearningLeadersRespDao>> {
        var response = MutableLiveData<List<LearningLeadersRespDao>>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val list: List<LearningLeadersRespDao> = Repository().getLearningLeaders()
                response.postValue(list)
            }
        }
        return response
    }
}