package com.saif.dpm1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.saif.dpm1.ui.theme.Dpm1Theme
import com.saif.dpm1.components.animations.MyCrossfade
import com.saif.dpm1.configLogin.generarMenuLogin
import com.saif.dpm1.database.FeedReaderDbHelper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val ssTimer = 4

        //class baseDeDatos(context: Context):FeedReaderDbHelper(context)
        val miBase = FeedReaderDbHelper()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Usamos Dpm1Theme en lugar de MaterialTheme
            Dpm1Theme {
                val miSelect= miBase.hacerSelect()
                print(miSelect)
                generarMenuLogin()
                //MyCrossfade(segundos = ssTimer)
            }
        }
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