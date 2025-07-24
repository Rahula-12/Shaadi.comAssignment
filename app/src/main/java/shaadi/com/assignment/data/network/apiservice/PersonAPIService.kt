package shaadi.com.assignment.data.network.apiservice

import retrofit2.http.GET
import retrofit2.http.Query
import shaadi.com.assignment.data.network.models.PersonsResponseDTO

interface PersonAPIService {

    @GET("api")
    suspend fun getPersonData(@Query("results") results:Int,@Query("page") page:Int):PersonsResponseDTO

}