package com.projeto.mamaecontente.ui.components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.NumberFormat
import java.util.Locale

class CurrencyVisualTransformation(private val locale: Locale = Locale("pt", "BR")) : VisualTransformation {

    private val currencyFormatter = NumberFormat.getCurrencyInstance(locale)

    override fun filter(text: AnnotatedString): TransformedText {
        val originalText = text.text
        val digitsOnly = originalText.filter { it.isDigit() }

        val amount = when {
            digitsOnly.isEmpty() -> 0.0
            else -> digitsOnly.toLong() / 100.0
        }

        val formattedText = currencyFormatter.format(amount)

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return formattedText.length
            }

            override fun transformedToOriginal(offset: Int): Int {
                return digitsOnly.length
            }
        }

        return TransformedText(
            AnnotatedString(formattedText),
            offsetMapping
        )
    }
}
