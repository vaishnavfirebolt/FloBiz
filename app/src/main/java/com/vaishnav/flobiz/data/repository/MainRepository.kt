package com.vaishnav.flobiz.data.repository

import com.vaishnav.flobiz.data.network.ApiService
import net.simplifiedcoding.multiviewlist.data.network.SafeApiCall
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: ApiService
) : SafeApiCall {
    suspend fun getQuestions() = safeApiCall { api.getQuestions() }
}