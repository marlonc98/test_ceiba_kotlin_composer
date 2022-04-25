package com.lamzentertainment.testceiba.ui.screens.posts.components

import android.content.Intent
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lamzentertainment.testceiba.R
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.ui.screens.posts.PostsActivity
import com.lamzentertainment.testceiba.ui.theme.GreenCeiba500

@Composable
    fun UserInPostCardComponent(user: UserEntity) {
    val context = LocalContext.current
    val openUserDetail : (()->Unit) = {
        val intent = Intent(context, PostsActivity::class.java)
        intent.putExtra("user", user.id)
        context.startActivity(intent)
    }
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
            Text(text = user.name, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = GreenCeiba500))
            Row {
                Icon(Icons.Filled.Phone, "phone", tint = GreenCeiba500)
                Spacer(Modifier.width(10.dp))
                Text(text = user.phone, overflow = TextOverflow.Ellipsis)
            }
            Row() {
                Icon(Icons.Filled.Email, "mail", tint = GreenCeiba500)
                Spacer(Modifier.width(10.dp))
                Text(text = user.email, overflow = TextOverflow.Ellipsis)
            }
        }
    }

}