package com.saif.dpm1.dataModelsHttp

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Url

private val SERVIDOR_DEV = "http://192.168.42.82"
private val PUERTO=":7001"
private const val SERVICIO_AUTENTICACION="ServicioAutentificacion"
private const val BASE_URL="/DPM/DPM-Security/DPM_WS/"
private val retrofit= Retrofit.Builder().
        baseUrl(SERVIDOR_DEV+PUERTO+BASE_URL).
        build()

interface MarsApiService{
    @POST(SERVICIO_AUTENTICACION)
    suspend fun getPhotos()
}

//declaramos un objeto para que no se cree un nuevo retrofit cada que se quiera utilizar
object MarsApi{
    val retrofitService: MarsApiService by lazy{
        retrofit.create(MarsApiService::class.java)
    }
}

interface APIService {
    @GET
    suspend fun getDogsByBreeds(@Url url: String): Response<modelsPerros>
}

interface ApiServicee {
    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Response<modelsPerros>
}
