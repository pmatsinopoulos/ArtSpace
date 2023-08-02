package com.mixlr.panos.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mixlr.panos.artspace.ui.theme.ArtSpaceTheme

private val artworks = listOf(
    ArtWork(
        imageId = R.drawable.mona_lisa,
        title = "Mona Lisa",
        subTitle = "M. Lisa",
        publicationYear = "1517"
    ),
    ArtWork(
        imageId = R.drawable.baptism_of_christ,
        title = "Baptism Of Christ",
        subTitle = "BOC",
        publicationYear = "1475"
    ),
    ArtWork(
        imageId = R.drawable.virgin_mary_jesus,
        title = "Virgin Mary And Jesus",
        subTitle = "VMJ",
        publicationYear = "1652"
    ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(
    modifier: Modifier = Modifier
) {
    var index by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        ArtworkImage(
            imageId = artworks[index].imageId,
            imageDescription = artworks[index].title
        )
        Spacer(modifier = Modifier.height(20.dp))
        ArtworkDescription(
            title = artworks[index].title,
            subTitle = artworks[index].subTitle,
            publicationYear = artworks[index].publicationYear,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )
        NavigationController(
            onPreviousClick = {
                index--
                if (index == -1) {
                    index = artworks.size - 1
                }
            },
            onNextClick = {
                index++
                if (index == artworks.size) {
                    index = 0
                }
            }
        )
    }
}

@Composable
fun ArtworkImage(
    @DrawableRes imageId: Int,
    imageDescription: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .border(border = BorderStroke(1.dp, Color.LightGray))
                .padding(30.dp),
            shadowElevation = 500.dp
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = imageDescription,
                contentScale = ContentScale.None,
            )
        }
    }
}

@Composable
fun NavigationController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavigationControllerButton(
            text = stringResource(R.string.previous),
            onClick = onPreviousClick
        )
        NavigationControllerButton(
            text = stringResource(R.string.next),
            onClick = onNextClick
        )
    }
}

@Composable
fun ArtworkDescription(
    title: String,
    subTitle: String,
    publicationYear: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            ArtworkTitle(title = title)
            ArtworkSubtitle(subTitle = subTitle, publicationYear = publicationYear)
        }
    }
}

@Composable
fun ArtworkTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        fontSize = 24.sp,
        text = title
    )
}

@Composable
fun ArtworkSubtitle(
    subTitle: String,
    publicationYear: String,
    modifier: Modifier = Modifier
) {
    Row(

    ) {
        Text(
            text = subTitle,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = " ($publicationYear)"
        )
    }
}

@Composable
fun NavigationControllerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(
                150.dp
            )
    ) {
        Text(text = text)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ArtSpace()
        }
    }
}
