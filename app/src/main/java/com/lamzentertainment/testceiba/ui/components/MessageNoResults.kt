package com.lamzentertainment.testceiba.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.lamzentertainment.testceiba.ui.utils.KMessageNoResults

@Composable
fun MessageNoResults (){
    Box(
    ) {
        //text centred in the box
        Text(
            text = KMessageNoResults,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}