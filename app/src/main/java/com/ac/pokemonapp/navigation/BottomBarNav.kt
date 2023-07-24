package com.ac.pokemonapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarNav(
    val route: String,
    val title: String,
    var icon: ImageVector
) {

    object HomeScreen : BottomBarNav(
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object PokedexScreen : BottomBarNav(
        route = "Pokedex",
        title = "Pokedex",
        icon = Icons.Default.Home
    )

    object FavoriteScreen : BottomBarNav(
        route = "Favorite",
        title = "Favorite",
        icon = Icons.Default.Home
    )

    object SettingScreen : BottomBarNav(
        route = "Setting",
        title = "Setting",
        icon = Icons.Default.Home
    )
}