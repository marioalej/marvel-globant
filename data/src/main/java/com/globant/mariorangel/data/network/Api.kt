package com.globant.mariorangel.data.network

import com.globant.mariorangel.models.RootResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(CHARACTERS)
    fun getCharacters(@Query(LIMIT) limit: Int) : Single<RootResponse>

    companion object {
        private const val CHARACTERS = "v1/public/characters"
        private const val LIMIT = "limit"
    }
}