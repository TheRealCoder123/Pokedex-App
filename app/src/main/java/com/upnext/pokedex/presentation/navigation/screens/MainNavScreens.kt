package com.upnext.pokedex.presentation.navigation.screens

sealed class MainNavScreens(val route: String) {
    object PokemonListScreen : MainNavScreens("pokemon_list_screen")
    object PokemonDetailScreen : MainNavScreens("pokemon_detail_screen") {
        const val DOMINANT_COLOR_ARG = "dominant_color_arg"
        const val POKEMON_NAME_ARG = "pokemon_name_arg"
    }
}
