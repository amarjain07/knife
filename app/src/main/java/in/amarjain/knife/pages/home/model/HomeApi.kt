package `in`.amarjain.knife.pages.home.model

import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {
    @GET("search.json")
    suspend fun searchImages(@Query("q") query: String, @Query("ijn") pageIndex: Int): HomeResponse
}