package com.ac.pokemonapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ac.pokemonapp.ui.theme.Typography

@Composable
fun PokemonItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (box, imageMain) = createRefs()
            val endGuideline = createGuidelineFromEnd(0.3f)

            Box(
                modifier = Modifier
                    .background(color = Color.Red, shape = RoundedCornerShape(12.dp))
                    .height(160.dp)
                    .fillMaxWidth()
                    .constrainAs(box) {
                        bottom.linkTo(parent.bottom)
                        linkTo(start = parent.start, end = parent.end)
                    },
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "#001",
                        color = Color.DarkGray,
                        style = Typography.displayMedium,
                        lineHeight = 18.sp,
                    )
                    Text(
                        text = "Bulbasur", color = Color.White, fontSize = 32.sp, style = Typography.titleMedium
                    )

                    LazyRow(
                        modifier = Modifier.padding(top = 12.dp)
                    ) {
                        items(2) {
                            TypePokemon()
                        }
                    }

                }

            }

            Image(
                painter = painterResource(id = R.drawable.pikachu),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .constrainAs(imageMain) {
                        end.linkTo(parent.end, margin = 12.dp)
                        top.linkTo(parent.top)
                        start.linkTo(endGuideline)
                        width = Dimension.fillToConstraints
                    })
        }

    }
}

@Composable
fun TypePokemon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(32.dp)
            .padding(end = 8.dp)
            .background(color = Color.White, shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_grass), contentDescription = "", modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Grass",
                modifier = Modifier.padding(start = 8.dp),
                color = Color.DarkGray,
                style = Typography.displayMedium,
                lineHeight = 18.sp,
            )
        }
    }

}

@Preview
@Composable
fun PokemonItemPreview() {
    MaterialTheme {
        PokemonItem()
    }
}