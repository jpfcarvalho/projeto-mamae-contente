package com.projeto.mamaecontente.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.projeto.mamaecontente.R

@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo Mamãe Contente",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}
