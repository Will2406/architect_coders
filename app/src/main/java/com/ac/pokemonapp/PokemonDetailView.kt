package com.ac.pokemonapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.ac.pokemonapp.ui.theme.Typography

@Composable
fun PokemonDetailScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE94219))
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (descriptionSection, backgroundSection, mainImage) = createRefs()
            val topGuideline = createGuidelineFromTop(0.4f)

            Image(
                painter = painterResource(id = R.drawable.ic_background_detail),
                contentDescription = null,
                modifier = Modifier
                    .zIndex(1f)
                    .padding(horizontal = 4.dp)
                    .constrainAs(backgroundSection) {
                        top.linkTo(topGuideline)
                        linkTo(start = parent.start, end = parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.pikachu),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .zIndex(2f)
                    .size(200.dp)
                    .constrainAs(mainImage) {
                        linkTo(start = parent.start, end = parent.end)
                        top.linkTo(backgroundSection.top)
                        bottom.linkTo(backgroundSection.top)
                    }
            )

            Column(
                modifier = Modifier
                    .zIndex(2f)
                    .constrainAs(descriptionSection) {
                        linkTo(start = parent.start, end = parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "About",
                        fontSize = 24.sp,
                        style = Typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.weight(1.5f)
                    )
                    Text(
                        text = "All >",
                        fontSize = 14.sp,
                        textAlign = TextAlign.End,
                        color = Color.White,
                        style = Typography.displayMedium,
                        modifier = Modifier.weight(0.5f)
                    )
                }


                Row(
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    PokemonStats(modifier = Modifier.weight(1f), image = R.drawable.energy, title = "Attack", value = "124")
                    PokemonStats(modifier = Modifier.weight(1f), image = R.drawable.protection, title = "Protection", value = "108")
                    PokemonStats(modifier = Modifier.weight(1f), image = R.drawable.healt, title = "Health", value = "70")
                    PokemonStats(modifier = Modifier.weight(1f), image = R.drawable.pokeball, title = "Chance to Catch", value = "%16")
                }

                PokemonDescription(
                    modifier = Modifier.padding(16.dp),
                    title = "Where to catch Pikachu",
                    description = "You can get Pikachu Pokémon from 2 km eggs, and" +
                            "there is also a chance to catch it. You can catch" +
                            "Pikachu at the very beginning of the game, when" +
                            "the irst 3 Pokémon aobear on the mao."
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailViewPreview() {
    MaterialTheme {
        PokemonDetailScreen()
    }
}
