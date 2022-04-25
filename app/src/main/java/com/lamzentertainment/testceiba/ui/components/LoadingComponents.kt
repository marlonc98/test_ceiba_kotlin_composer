package com.lamzentertainment.testceiba.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingComponents (){
    Box() {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            CircularProgressIndicator()
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Cargando")
        }
    }
}