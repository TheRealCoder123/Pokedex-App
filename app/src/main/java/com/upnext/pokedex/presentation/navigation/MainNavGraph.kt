package com.upnext.pokedex.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.upnext.pokedex.presentation.navigation.screens.MainNavScreens


@Composable
fun MainNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = MainNavScreens.PokemonListScreen.route) {
        composable(MainNavScreens.PokemonListScreen.route){

        }
        composable(
            MainNavScreens.PokemonDetailScreen.route +
                    "/{{${MainNavScreens.PokemonDetailScreen.DOMINANT_COLOR_ARG}}" +
                    "/{{${MainNavScreens.PokemonDetailScreen.POKEMON_NAME_ARG}}",
            arguments = listOf(
                navArgument(MainNavScreens.PokemonDetailScreen.DOMINANT_COLOR_ARG){
                    type = NavType.IntType
                },
                navArgument(MainNavScreens.PokemonDetailScreen.POKEMON_NAME_ARG){
                    type = NavType.StringType
                }

            )
        ){
            val dominantColor = remember {
                val color = it.arguments?.getInt(MainNavScreens.PokemonDetailScreen.DOMINANT_COLOR_ARG)
                color?.let { Color(it) } ?: Color.White
            }
            val pokemonName = remember {
                it.arguments?.getString(MainNavScreens.PokemonDetailScreen.POKEMON_NAME_ARG)
            }
        }
    }
}