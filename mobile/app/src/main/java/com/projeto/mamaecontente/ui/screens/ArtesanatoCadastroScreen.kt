package com.projeto.mamaecontente.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.projeto.mamaecontente.ui.components.AppLogo
import com.projeto.mamaecontente.ui.components.CustomTextField
import com.projeto.mamaecontente.ui.components.DefaultTopAppBar
import com.projeto.mamaecontente.ui.components.ImageSelector
import com.projeto.mamaecontente.ui.components.PrimaryButton
import com.projeto.mamaecontente.ui.theme.MamaeContenteTheme
import com.projeto.mamaecontente.ui.viewmodel.ArtesanatoViewModel

@Composable
fun ArtesanatoCadastroScreen(
    navController: NavController,
    viewModel: ArtesanatoViewModel = hiltViewModel()
) {
    var nome by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var quantidade by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val detailState by viewModel.detailUiState.collectAsState()

    val isFormValid by remember {
        derivedStateOf {
            nome.isNotBlank() &&
            categoria.isNotBlank() &&
            preco.isNotBlank() &&
            quantidade.isNotBlank()
        }
    }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> imageUri = uri }
    )

    LaunchedEffect(detailState.isSaved) {
        if (detailState.isSaved) {
            navController.popBackStack()
        }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            DefaultTopAppBar(
                title = "Cadastro",
                navController = navController
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppLogo(modifier = Modifier.height(100.dp).padding(bottom = 24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    CustomTextField(value = nome, onValueChange = { nome = it }, label = "Nome")
                    Spacer(modifier = Modifier.height(16.dp))
                    CustomTextField(value = categoria, onValueChange = { categoria = it }, label = "Categoria")
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        CustomTextField(
                            value = preco,
                            onValueChange = {
                                preco = it.filter { char -> char.isDigit() }
                            },
                            label = "Preço",
                            modifier = Modifier.weight(1f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            visualTransformation = com.projeto.mamaecontente.ui.components.CurrencyVisualTransformation()
                        )
                        CustomTextField(
                            value = quantidade,
                            onValueChange = {
                                quantidade = it.filter { char -> char.isDigit() }
                            },
                            label = "Quantidade",
                            modifier = Modifier.weight(1f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    ImageSelector(
                        imageUri = imageUri?.toString(),
                        onImageSelected = {
                            photoPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (detailState.isLoading) {
                CircularProgressIndicator()
            } else {
                PrimaryButton(
                    text = "Salvar",
                    onClick = {
                        val priceDouble = preco.toDoubleOrNull()?.div(100.0) ?: 0.0
                        val quantityInt = quantidade.toIntOrNull() ?: 0
                        viewModel.addArtesanato(
                            name = nome,
                            price = priceDouble,
                            quantity = quantityInt,
                            imageUrl = imageUri?.toString() ?: ""
                        )
                    },
                    enabled = isFormValid
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtesanatoCadastroScreenPreview() {
    MamaeContenteTheme {
        ArtesanatoCadastroScreen(navController = rememberNavController())
    }
}