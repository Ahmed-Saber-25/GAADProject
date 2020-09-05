package com.alyndroid.tabbedviews.repository

import com.alyndroid.tabbedviews.model.RetrofitClient

class Repository {
    private val webService = RetrofitClient.doRetrofitService()

    suspend fun getLearningLeaders() = webService.getLearningLeaders()
    suspend fun getSkillIQLeaders() = webService.getSkillIQLeaders()
    suspend fun submitProject(
        emailAddress: String,
        name: String,
        lastName: String,
        linkToProject: String
    ) = webService.submitProject(emailAddress, name, lastName, linkToProject)
}