package com.rene.ferrari.catadoption

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.rene.ferrari.catadoption.ui.theme.CatAdoptionTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatAdoptionTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigator()
                }
            }
        }
    }
}

data class Cat(val id: Int, val imgName: String, val catName: String)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatAdoptionTheme {
        CatList(rememberNavController(), getCats())
    }
}

@Composable
fun Navigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { CatList(navController, getCats()) }
        composable(
            "detail/{catId}",
            arguments = listOf(
                navArgument("catId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            backStackEntry?.arguments?.getInt("catId")?.let { catId ->
                val cat = getCats().first { it.id == catId }
                val catDetail = getCatDetails().first { it.id == catId }
                CatDetail(cat, catDetail)
            }
        }
    }
}

@Composable
fun CatList(navHostController: NavHostController, cats: List<Cat>) {
    Column(
        modifier = Modifier
            .verticalScroll(state = ScrollState(0))
    ) {
        cats.forEach { cat ->
            CatRow(navHostController, cat)
        }
    }
}

@Composable
fun CatRow(navHostController: NavHostController, cat: Cat) {
    Row(
        modifier = Modifier
            .clickable {
                navHostController.navigate("detail/${cat.id}")
            }
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Image(
            bitmap = getImage(LocalContext.current, cat.imgName),
            contentDescription = "Image of cat ${cat.catName}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Text(
            text = cat.catName,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp),
        )
    }
}

fun getImage(context: Context, imgName: String) =
    BitmapFactory.decodeStream(context.assets.open("$imgName.jpg")).asImageBitmap()

fun getCats() = listOf(
    Cat(
        1,
        "cat1",
        "Pepper"
    ),
    Cat(
        2,
        "cat2",
        "Frank"
    ),
    Cat(
        3,
        "cat3",
        "Lola"
    ),
    Cat(
        4,
        "cat4",
        "Gus"
    ),
    Cat(
        5,
        "cat5",
        "Lillie"
    ),
    Cat(6,
        "cat6",
        "Buddy"
    ),
    Cat(
        7,
        "cat7",
        "Daisy"
    ),
    Cat(
        8,
        "cat8",
        "Oreo"
    ),
    Cat(
        9,
        "cat9",
        "Jack"
    )
)
