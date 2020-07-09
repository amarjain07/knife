package `in`.amarjain.knife.pages.home.model

interface HomeRepository {
    suspend fun searchImages(query: String): HomeResponse
}

class HomeRepositoryImpl(private val api: HomeApi) : HomeRepository {
    override suspend fun searchImages(query: String): HomeResponse {
        return api.searchImages(query, 0)
    }
}