package com.projeto.mamaecontente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.projeto.mamaecontente.ui.AppNavigation
import com.projeto.mamaecontente.ui.theme.MamaeContenteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MamaeContenteTheme {
                AppNavigation()
            }
        }
    }
}