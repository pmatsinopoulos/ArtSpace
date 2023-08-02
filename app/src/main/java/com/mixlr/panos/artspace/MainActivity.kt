package com.mixlr.panos.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mixlr.panos.artspace.ui.theme.ArtSpaceTheme

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row() {

        }
        ArtworkDescription(
            title = "Still Life of Blue Rose and Other Flowers",
            subTitle = "Owen Scott",
            publicationYear = "2021",
            modifier = Modifier
                .padding(bottom = 20.dp)
        )
        NavigationController()
    }
}

@Composable
fun NavigationController(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavigationControllerButton(text = stringResource(R.string.previous))
        NavigationControllerButton(text = stringResource(R.string.next))
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
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /*TODO*/ },
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
