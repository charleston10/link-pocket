package com.data.data_cloud.api

import com.data.data_cloud.response.PreviewResponse
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST

interface GitHubApi {
    @GET("lucaslmartins14/link-pocket/master/api/get_list.json")
    fun getList(): Observable<List<PreviewResponse>>
}