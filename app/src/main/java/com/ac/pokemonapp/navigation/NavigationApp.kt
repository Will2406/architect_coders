package com.ac.pokemonapp.navigation


import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ac.pokemonapp.FavoriteScreen
import com.ac.pokemonapp.HomeScreen
import com.ac.pokemonapp.PokemonDetailScreen
import com.ac.pokemonapp.SettingScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarNav.HomeScreen.route) {
        composable(route = BottomBarNav.HomeScreen.route) { HomeScreen() }
        composable(route = BottomBarNav.PokedexScreen.route) { PokemonDetailScreen() }
        composable(route = BottomBarNav.FavoriteScreen.route) { FavoriteScreen() }
        composable(route = BottomBarNav.SettingScreen.route) { SettingScreen() }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val listItems = listOf(
        BottomBarNav.HomeScreen,
        BottomBarNav.PokedexScreen,
        BottomBarNav.FavoriteScreen,
        BottomBarNav.SettingScreen
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        listItems.forEachIndexed { _, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}