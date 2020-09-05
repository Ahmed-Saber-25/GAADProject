package com.alyndroid.tabbedviews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.alyndroid.tabbedviews.repository.Repository
import com.alyndroid.tabbedviews.view.SubmitProjectActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubmitProjectViewModel(application: Application) : AndroidViewModel(application) {
    var context: SubmitProjectActivity? = null

    fun submitProject(
        emailAddress: String,
        firstName: String,
        lastName: String,
        linkToProject: String
    ) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (Repository().submitProject(
                        emailAddress,
                        firstName,
                        lastName,
                        linkToProject
                    ).isExecuted
                ) {
                    context?.submissionSuccessful()
                } else {
                    context?.submissionNotSuccessful()
                }
            }
        }
    }
}
