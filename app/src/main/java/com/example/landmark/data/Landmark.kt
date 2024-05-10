package com.example.landmark.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.landmark.R

enum class Landmark(nameId: Int, region: Region, heightMeters: Float, heightFeet: Float, floorCount: Int, year: Number, imageId: Int, googleMapUri: String) {
    BurjKhalifa(
        R.string.burj_khalifa,
        Region.UnitedArabEmirates,
        heightMeters = 828f,
        heightFeet = 2717f,
        floorCount = 163,
        year = 2010,
        R.drawable.burj_khalifa,
        "https://maps.app.goo.gl/JXqq3yzQM87JP2H99"
    ),
    Merdeka118(
        R.string.merdeka_118,
        Region.Malaysia,
        heightMeters = 678.9f,
        heightFeet = 2227f,
        floorCount = 118,
        year = 2023,
        R.drawable.merdeka118,
        "https://maps.app.goo.gl/Wfq1muDNaG7ajTzt6"
    ),
    TheClockTowers(
        R.string.the_clock_towers,
        Region.SaudiArabia,
        heightMeters = 601f,
        heightFeet = 1972f,
        floorCount = 120,
        year = 2012,
        R.drawable.the_clock_towers,
        "https://maps.app.goo.gl/onoQpT5BsLKogfXbA"
    ),
    ShanghaiTower(
        R.string.shanghai_tower,
        Region.MainlandChina,
        heightMeters = 632f,
        heightFeet = 2073f,
        floorCount = 128,
        year = 2015,
        R.drawable.shanghai_tower,
        "https://maps.app.goo.gl/KQHU7FVcQtyJNRACA"
    ),
    PingAnFinanceCenter(
        R.string.ping_an_finance_center,
        Region.MainlandChina,
        heightMeters = 599.1f,
        heightFeet = 1966f,
        floorCount = 115,
        year = 2017,
        R.drawable.ping_an_finance_center,
        "https://maps.app.goo.gl/9yWtf47TP1N8XU5v6"
    ),
    LotteWorldTower(
        R.string.lotte_world_tower,
        Region.SouthKorea,
        heightMeters = 554.5f,
        heightFeet = 1819f,
        floorCount = 123,
        year = 2017,
        R.drawable.lotte_world_tower,
        "https://maps.app.goo.gl/A6zCgR2Kj3WBCuUf8"
    ),
    OneWorldTradeCenter(
        R.string.one_world_trade_center,
        Region.UniteStatesOfAmerica,
        heightMeters = 541.3f,
        heightFeet = 1776f,
        floorCount = 94,
        year = 2014,
        R.drawable.one_world_trade_center,
        "https://maps.app.goo.gl/ezqvJSXz5wjpQHL97"
    ),
    GuangzhouCTFFinanceCentre(
        R.string.guangzhou_CTF_finance_centre,
        Region.MainlandChina,
        heightMeters = 530f,
        heightFeet = 1739f,
        floorCount = 111,
        year = 2016,
        R.drawable.guangzhou_ctf_finance_centre,
        "https://maps.app.goo.gl/bUVererSqm95wrFe8"
    ),
    TianjinCTFFinanceCentre(
        R.string.tianjin_CTF_finance_centre,
        Region.MainlandChina,
        heightMeters = 530f,
        heightFeet = 1739f,
        floorCount = 97,
        year = 2019,
        R.drawable.tianjin_ctf_finance_centre,
        "https://maps.app.goo.gl/t4sXBreUXbDgh1Cx7"
    ),
    CITICTower(
        R.string.CITIC_tower,
        Region.MainlandChina,
        heightMeters = 527.7f,
        heightFeet = 1731f,
        floorCount = 109,
        year = 2018,
        R.drawable.citic_tower,
        "https://maps.app.goo.gl/xTuyae8C52uzKuF77"
    ),
    Taipei101(
        R.string.taipei101,
        Region.TaiwanAreaOfTheRepublicOfChina,
        heightMeters = 509.2f,
        heightFeet = 1667f,
        floorCount = 101,
        year = 2004,
        R.drawable.taipei101,
        "https://maps.app.goo.gl/pXhV8XTGKe1nkcpL7"
    ),
    ShanghaiWorldFinancialCenter(
        R.string.shanghai_world_financial_center,
        Region.MainlandChina,
        heightMeters = 492f,
        heightFeet = 1614f,
        floorCount = 101,
        year = 2008,
        R.drawable.shanghai_world_financial_center,
        "https://maps.app.goo.gl/bUM3HPtkaRH1Z5eU9"
    );

    val getName = @Composable {stringResource(nameId)}
    val getImage = @Composable { painterResource(imageId)}
    val height = heightMeters;
    val heightFeet = heightFeet;
    val region = region;
    val year = year;
    val location = googleMapUri
}

