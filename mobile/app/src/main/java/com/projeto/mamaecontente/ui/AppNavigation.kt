package com.projeto.mamaecontente.ui

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.projeto.mamaecontente.ui.screens.*
import com.projeto.mamaecontente.ui.viewmodel.ArtesanatoViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.ArtesanatoListagem.route) {
            val viewModel: ArtesanatoViewModel = hiltViewModel()
            ArtesanatoListagemScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.ArtesanatoCadastro.route) {
            val viewModel: ArtesanatoViewModel = hiltViewModel()
            ArtesanatoCadastroScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            route = Screen.ArtesanatoEdicao.route + "/{artesanatoId}",
            arguments = listOf(navArgument("artesanatoId") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel: ArtesanatoViewModel = hiltViewModel()
            ArtesanatoEdicaoScreen(
                navController = navController,
                artesanatoId = backStackEntry.arguments?.getString("artesanatoId"),
                viewModel = viewModel
            )
        }
        composable(Screen.BazarListagem.route) {
            BazarListagemScreen(navController)
        }
        composable(Screen.BazarCadastro.route) {
            BazarCadastroScreen(navController)
        }
        composable(Screen.DoacaoListagem.route) {
            DoacaoListagemScreen(navController)
        }
        composable(Screen.DoacaoCadastro.route) {
            DoacaoCadastroScreen(navController)
        }
        composable(Screen.DoacaoEdicao.route) {
            DoacaoEdicaoScreen(navController)
        }
    }
}
