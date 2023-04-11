package com.example.cookpedia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import com.example.cookpedia.R
import com.example.cookpedia.ui.theme.PrimaryRedColor


private lateinit var _nameUser:String
private lateinit var _userId:String


@Composable
private fun UserImage() {
    AsyncImage(
        modifier = Modifier
            .height(76.dp)
            .width(76.dp)
            .clip(
                shape = CircleShape
            ),
        model = ImageRequest.Builder(LocalContext.current)
            .data( R.drawable.daniel)
            .precision(Precision.AUTOMATIC)
            .crossfade(true)
            .build(),
        contentDescription = "User",
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun InfoUser() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = _nameUser,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = _userId,
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}

@Composable
private fun CustomActionButton(
    content:@Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .clip(shape = AbsoluteRoundedCornerShape(18.dp))
            .background(PrimaryRedColor)
            .padding(horizontal = 18.dp, vertical = 8.dp),
        content = content
        )
}

@Composable
fun CustomInfoCardUser(
    name:String,
    userId:String,
    action: @Composable() (BoxScope.() -> Unit)? = null,
) {
    _nameUser = name
    _userId = userId
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserImage()
        Spacer(modifier = Modifier.width(15.dp))
        Box(modifier = Modifier.weight(1F)){
            InfoUser()
        }
        
        if (action!=null){
            Spacer(modifier = Modifier.width(15.dp))
            CustomActionButton(action)
        }
        


    }
}