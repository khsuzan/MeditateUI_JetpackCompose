package com.kawsar.meditatekotlin.views.subviews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawsar.meditatekotlin.models.NavIndex
import com.kawsar.meditatekotlin.models.NavItemInfo
import com.kawsar.meditatekotlin.ui.theme.KODCHASAN
import com.kawsar.meditatekotlin.ui.theme.darkBlue
import com.kawsar.meditatekotlin.ui.theme.lightBlue
import com.kawsar.meditatekotlin.ui.theme.navBg

@Composable
fun BottomBar(
    navs: List<NavItemInfo>,
    defaultIndex: NavIndex,
    onNavTap: (NavIndex) -> Unit,
    backGround: Color = darkBlue,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backGround),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        navs.forEach { itemInfo ->
            NavItem(
                modifier = Modifier.weight(1f),
                navItem = itemInfo,
                isSelected = itemInfo.navIndex == defaultIndex,
                onNavTap = {
                    onNavTap(it)
                })
        }
    }

}

@Composable
fun NavItem(
    modifier: Modifier,
    navItem: NavItemInfo,
    isSelected: Boolean,
    onNavTap: (NavIndex) -> Unit,
) {

    Column(
        modifier = modifier
            .clickable {
                onNavTap(navItem.navIndex)
            }
            .padding(top = 8.dp, start = 5.dp, end = 5.dp, bottom = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(
                    color = if (isSelected) navBg else Color.Transparent,
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(6.dp),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                painter = painterResource(id = navItem.icon),
                contentDescription = navItem.label,
                tint = if (isSelected) Color.White else lightBlue
            )
        }
        Text(text = navItem.label,
            fontFamily = KODCHASAN,
            fontSize = 13.sp,
            color = if (isSelected) Color.White else lightBlue,
            fontWeight = FontWeight.Normal)
    }
}