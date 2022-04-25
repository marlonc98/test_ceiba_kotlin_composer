package com.lamzentertainment.testceiba.ui.screens.posts.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.ui.theme.GreenCeiba500

@Composable
fun PostCardComponent(post: PostEntity) {
    Card(
        shape = RoundedCornerShape(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        elevation = 8.dp,
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = post.title, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = GreenCeiba500))
            Text(text = post.body, style = TextStyle(fontSize = 14.sp))
        }
    }
}