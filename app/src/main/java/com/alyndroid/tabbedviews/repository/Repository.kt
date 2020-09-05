package com.alyndroid.tabbedviews.repository

import com.alyndroid.tabbedviews.model.RetrofitClient

class Repository {
    private val webService = RetrofitClient.doRetrofitService()
    private val webServiceSubmission = RetrofitClient.doSubmissionService()
    suspend fun getLearningLeaders() = webService.getLearningLeaders()
    suspend fun getSkillIQLeaders() = webService.getSkillIQLeaders()
    fun submitProject(
        emailAddress: String,
        name: String,
        lastName: String,
        linkToProject: String
    ) = webServiceSubmission.submitProject(emailAddress, name, lastName, linkToProject)
}