package com.saif.dpm1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.saif.dpm1.ui.theme.Dpm1Theme
import com.saif.dpm1.components.animations.MyCrossfade
import com.saif.dpm1.configLogin.generarMenuLogin
import com.saif.dpm1.dataModelsHttp.APIService
import com.saif.dpm1.dataModelsHttp.MarsApi
import com.saif.dpm1.dataModelsHttp.modelsPerros
import com.saif.dpm1.database.FeedReaderDbHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val ssTimer = 4

        //class baseDeDatos(context: Context):FeedReaderDbHelper(context)
        val miBase = FeedReaderDbHelper()
        val miSelect= miBase.hacerSelect()
        print(miSelect)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Usamos Dpm1Theme en lugar de MaterialTheme
            Dpm1Theme {
                getMarsPhotos()
                generarMenuLogin()
                //MyCrossfade(segundos = ssTimer)
            }
        }
    }

    //retrofit
//    private fun getRetrofit():Retrofit{
//        return Retrofit.Builder()
//            .baseUrl("https://dog.ceo/api/breed/")//siempre debe terminar con una /
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

    private fun getMarsPhotos(){
        CoroutineScope(Dispatchers.IO).launch {
            val listResult= MarsApi.retrofitService.getPhotos()
            print(listResult)
            return@launch
        }
    }

//    private fun searchByName(query:String){
//        CoroutineScope(Dispatchers.IO).launch {  //todo aqui se hara en un hilo secundario
//            val call= getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
//            val puppies=call.body()
//            runOnUiThread {
//                if(call.isSuccessful){
//                    val images=puppies?.images ?: emptyList()
//
//                }else{
//                    showError()
//                }
//            }
//
//        }
//    }

    private fun showError(){
        Toast.makeText(this,"Ha ocurrido un error",Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun Greeting(name: String) {
        // Esta funcion ya no se usa pero la mantenemos
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Dpm1Theme {
            Greeting("Android")
        }
    }
}