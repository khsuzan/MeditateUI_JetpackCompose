package com.kawsar.meditatekotlin.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kawsar.meditatekotlin.data.ViewsData.bottomNavs
import com.kawsar.meditatekotlin.models.NavIndex
import com.kawsar.meditatekotlin.ui.theme.darkBlue
import com.kawsar.meditatekotlin.views.subviews.BottomBar

@Composable
fun MainScreen() {
    var navIndex by rememberSaveable {
        mutableStateOf(NavIndex.HOME)
    }
    return Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            BottomBar(navs = bottomNavs,
                defaultIndex = navIndex,
                onNavTap = {
                    navIndex = it
                })
        },
        backgroundColor = darkBlue
    ) {
        HomeScreen(it)
    }
}