import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.projeto.mamaecontente.ui.Screen
import com.projeto.mamaecontente.ui.components.AppLogo
import com.projeto.mamaecontente.ui.components.MenuButton
import com.projeto.mamaecontente.ui.theme.MamaeContenteTheme

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            AppLogo(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            MenuButton(
                text = "Estoque Artesanato",
                icon = Icons.Default.Checkroom,
                onClick = { navController.navigate(Screen.ArtesanatoListagem.route) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton(
                text = "Bazar",
                icon = Icons.Default.Storefront,
                onClick = { navController.navigate("bazar_listagem") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton(
                text = "Estoque Doações",
                icon = Icons.Default.VolunteerActivism,
                onClick = { navController.navigate("doacao_listagem") }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 740)
@Composable
fun HomeScreenPreview() {
    MamaeContenteTheme {
        HomeScreen(navController = rememberNavController())
    }
}
