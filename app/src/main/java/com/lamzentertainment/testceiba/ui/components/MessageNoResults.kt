package com.lamzentertainment.testceiba.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.lamzentertainment.testceiba.R

@Composable
fun MessageNoResults (){
    Box(
    ) {
        //text centred in the box
        Text(
            text = stringResource(id = R.string.message_no_results),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}