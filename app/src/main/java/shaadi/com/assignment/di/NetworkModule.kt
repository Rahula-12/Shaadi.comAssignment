package shaadi.com.assignment.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import shaadi.com.assignment.data.network.apiservice.PersonAPIService
import shaadi.com.assignment.utils.BASE_URL
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofitInstance():Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providesAPIInstance(retrofit: Retrofit):PersonAPIService {
        return retrofit.create(PersonAPIService::class.java)
    }

}