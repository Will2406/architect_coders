package com.ac.pokemonapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonStats(modifier: Modifier = Modifier, image: Int? = null, title: String, value: String) {
    Box(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .height(140.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image ?: R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            Text(
                text = title,
                fontSize = 10.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
            )
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}


@Composable
fun PokemonDescription(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Where to catch Pikachu",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "You can get Pikachu Pokémon from 2 km eggs, and" +
                        "there is also a chance to catch it. You can catch" +
                        "Pikachu at the very beginning of the game, when" +
                        "the irst 3 Pokémon aobear on the mao.",
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF9E2E0)),
                    border = BorderStroke(width = 8.dp, color = Color(0xFFF9E2E0))
                ) {
                    Text(
                        text = "To Favorites",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFE94219)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94219)),
                    border = BorderStroke(width = 8.dp, color = Color(0xFFE94219))
                ) {
                    Text(
                        text = "Open the Map",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFF9E2E0)
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun PokemonStatsPreview() {
    MaterialTheme {
        Row {
            PokemonStats(modifier = Modifier.weight(1f), title = "Attack", value = "124")
            PokemonStats(modifier = Modifier.weight(1f), title = "Protection", value = "108")
            PokemonStats(modifier = Modifier.weight(1f), title = "Health", value = "70")
            PokemonStats(modifier = Modifier.weight(1f), title = "Chance to Catch", value = "%16")
        }

    }
}

@Preview
@Composable
fun PokemonDescriptionPreview() {
    MaterialTheme {
        PokemonDescription()
    }
}