package com.alyndroid.tabbedviews.model

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi {
    @GET("hours")
    suspend fun getLearningLeaders(): List<LearningLeadersRespDao>

    @GET("skilliq")
    suspend fun getSkillIQLeaders(): List<SkillIQLeadersRespDao>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.1877115667") name: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") linkToProject: String
    ): Call<Void>


}