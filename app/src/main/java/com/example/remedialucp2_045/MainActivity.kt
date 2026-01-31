package com.example.remedialucp2_045

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.remedialucp2_045.theme.RemedialUCP2_045Theme
import com.example.remedialucp2_045.view.uicontroller.PetaNavigasi

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RemedialUCP2_045Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    PetaNavigasi(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
