package com.rene.ferrari.catadoption

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rene.ferrari.catadoption.ui.theme.CatAdoptionTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    CatAdoptionTheme {
        CatDetail(cat = getCats().first(), catDetail = getCatDetails().first())
    }
}

@Composable
fun CatDetail(cat: Cat, catDetail: CatDetail) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = cat.catName,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
        Image(
            bitmap = getImage(LocalContext.current, cat.imgName),
            contentDescription = "Image of cat ${cat.catName}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp)
                .size(156.dp)
                .clip(CircleShape)
        )
        Text(
            fontSize = 24.sp,
            text = catDetail.characteristic,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp)
        )
        Text(
            text = "Height: ${catDetail.heightInCm}cm",
            modifier = Modifier.padding(start = 16.dp, top = 24.dp)
        )
        Text(
            text = "Weight: ${catDetail.weightInKg}kg",
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "Birth date: ${catDetail.birthDateStr}",
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

fun getCatDetails() = listOf(
    CatDetail(
        id = 1,
        heightInCm = 30f,
        weightInKg = 4.5f,
        birthDateStr = "1.1.2019",
        characteristic = "Always happy"
    ),
    CatDetail(
        id = 2,
        heightInCm = 36f,
        weightInKg = 8f,
        birthDateStr = "5.5.2015",
        characteristic = "Cheerful"
    ),
    CatDetail(
        id = 3,
        heightInCm = 45f,
        weightInKg = 7f,
        birthDateStr = "4.6.2014",
        characteristic = "Sweet"
    ),
    CatDetail(
        id = 4,
        heightInCm = 16f,
        weightInKg = 3.4f,
        birthDateStr = "1.5.2013",
        characteristic = "Curious"
    ),
    CatDetail(
        id = 5,
        heightInCm = 26f,
        weightInKg = 5.8f,
        birthDateStr = "23.9.2019",
        characteristic = "Friendly"
    ),
    CatDetail(
        id = 6,
        heightInCm = 18f,
        weightInKg = 7f,
        birthDateStr = "1.5.2019",
        characteristic = "Good Friend"
    ),
    CatDetail(
        id = 7,
        heightInCm = 34f,
        weightInKg = 5.2f,
        birthDateStr = "2.3.2000",
        characteristic = "Gentle"
    ),
    CatDetail(
        id = 8,
        heightInCm = 20f,
        weightInKg = 5f,
        birthDateStr = "1.12.2019",
        characteristic = "Playful"
    ),
    CatDetail(
        id = 9,
        heightInCm = 30f,
        weightInKg = 4.5f,
        birthDateStr = "1.1.2019",
        characteristic = "Intelligent"
    )
)

data class CatDetail(
    val id: Int,
    val heightInCm: Float,
    val weightInKg: Float,
    val birthDateStr: String,
    val characteristic: String
)