package com.projeto.mamaecontente.ui

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object ArtesanatoListagem : Screen("artesanato_listagem")
    object ArtesanatoCadastro : Screen("artesanato_cadastro")
    object ArtesanatoEdicao : Screen("artesanato_edicao")
    object BazarListagem : Screen("bazar_listagem")
    object BazarCadastro : Screen("bazar_cadastro")
    object DoacaoListagem : Screen("doacao_listagem")
    object DoacaoCadastro : Screen("doacao_cadastro")
    object DoacaoEdicao : Screen("doacao_edicao")
}
