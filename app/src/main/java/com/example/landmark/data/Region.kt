package com.example.landmark.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.landmark.R

enum class Region(nameId: Int, flagId: Int) {
    Malaysia(
        R.string.malaysia,
        R.drawable.flag_of_malaysia
    ),
    MainlandChina(
        R.string.mainland_china,
        R.drawable.flag_of_the_people_s_republic_of_china
    ),
    SaudiArabia(
        R.string.saudi_arabia,
        R.drawable.flag_of_saudi_arabia
    ),
    SouthKorea(
        R.string.south_korea,
        R.drawable.flag_of_south_korea
    ),
    TaiwanAreaOfTheRepublicOfChina(
        R.string.taiwan_area_of_the_republic_of_china,
        R.drawable.flag_of_the_republic_of_china
    ),
    UnitedArabEmirates(
        R.string.united_arab_emirates,
        R.drawable.flag_of_the_united_arab_emirates
    ),
    UniteStatesOfAmerica(
        R.string.united_states_of_america,
        R.drawable.flag_of_the_united_states
    );

    val getName = @Composable { stringResource(id = nameId)}
    val getImage = @Composable { painterResource(id = flagId)}
}