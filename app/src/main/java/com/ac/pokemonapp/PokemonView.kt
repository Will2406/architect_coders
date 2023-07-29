package com.ac.pokemonapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ac.pokemonapp.ui.theme.Typography

@Composable
fun PokemonScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFE94219))
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {

            val (footerSection, headerSection, imageMain) = createRefs()

            Column(
                modifier = Modifier.constrainAs(headerSection) {
                    linkTo(start = parent.start, end = parent.end)
                    linkTo(top = parent.top, bottom = parent.bottom, bias = 0.15f)
                }) {

                ConstraintLayout {

                    val (titleHeader, subTitleHeader) = createRefs()

                    Text(
                        text = "Pikachu",
                        fontSize = 54.sp,
                        color = Color.White,
                        style = Typography.titleMedium,
                        modifier = Modifier.constrainAs(titleHeader) {
                            linkTo(start = parent.start, end = parent.end)
                            top.linkTo(parent.top)
                        }
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.constrainAs(subTitleHeader) {
                            end.linkTo(titleHeader.end)
                            top.linkTo(titleHeader.bottom)

                        },
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pokeball),
                            contentDescription = "", modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Electric",
                            fontSize = 16.sp,
                            color = Color.White,
                            style = Typography.titleMedium,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }

            }

            Image(
                painter = painterResource(id = R.drawable.pikachu_main),
                contentDescription = "",
                modifier = Modifier
                    .size(300.dp)
                    .constrainAs(imageMain) {
                        linkTo(start = parent.start, end = parent.end)
                        linkTo(top = headerSection.bottom, bottom = footerSection.top, bias = 0.2f)
                    }
            )

            Row(modifier = Modifier
                .padding(16.dp)
                .constrainAs(footerSection) {
                    bottom.linkTo(parent.bottom)
                    linkTo(start = parent.start, end = parent.end)

                }) {
                Button(
                    onClick = { }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Color.Black),

                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "About", fontSize = 16.sp, modifier = Modifier.padding(vertical = 12.dp), style = Typography.displayMedium
                    )
                }
                Spacer(modifier = Modifier.weight(0.2f))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFBF00)),
                    modifier = Modifier.weight(0.5f),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Text(
                        text = "+", fontSize = 16.sp, modifier = Modifier.padding(vertical = 12.dp), style = Typography.displayMedium
                    )
                }
                Spacer(modifier = Modifier.weight(0.2f))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6C6B9)),
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Evolution", fontSize = 16.sp, modifier = Modifier.padding(vertical = 12.dp), style = Typography.displayMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PokemonScreenPreview() {
    MaterialTheme {
        PokemonScreen()
    }
}