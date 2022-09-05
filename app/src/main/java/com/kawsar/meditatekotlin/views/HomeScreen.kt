package com.kawsar.meditatekotlin.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawsar.meditatekotlin.R
import com.kawsar.meditatekotlin.data.ViewsData
import com.kawsar.meditatekotlin.data.ViewsData.chips
import com.kawsar.meditatekotlin.models.FeaturedInfo
import com.kawsar.meditatekotlin.ui.theme.*

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    var chipIndex by rememberSaveable {
        mutableStateOf(0)
    }
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        item {
            Spacer(modifier = Modifier.height(20.dp))
            GreetingSection()
            Spacer(modifier = Modifier.height(35.dp))
            ChipsSection(chips = chips,
                defaultIndex = chipIndex,
                onChipClick = { chipIndex = it }
            )
            Spacer(modifier = Modifier.height(25.dp))
            DailyThought()
            Spacer(modifier = Modifier.height(45.dp))
            FetureTitle()
            Spacer(modifier = Modifier.height(20.dp))
            FeaturedItems()

        }
    }
}

@Composable
fun GreetingSection() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier,
            horizontalAlignment = Alignment.Start) {
            Text(text = "Good Morning, Suzan",
                fontSize = 22.sp,
                fontFamily = MONTSERRAT,
                fontWeight = FontWeight.Medium,
                color = HeadLineText)
            Text(
                text = "we wish you have a good day!",
                fontSize = 14.sp,
                fontFamily = MONTSERRAT,
                color = greyed,
            )
        }
        Icon(
            modifier = Modifier.size(28.dp),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White)
    }
}

@Composable
fun ChipsSection(
    chips: List<String>,
    defaultIndex: Int,
    onChipClick: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.Start) {
        chips.forEachIndexed { index, chip ->
            Chip(label = chip, isSelected = defaultIndex == index) {
                onChipClick(index)
            }
        }
    }
}

@Composable
fun Chip(
    label: String,
    isSelected: Boolean,
    onTap: () -> Unit,
) {
    Box(modifier = Modifier
        .padding(end = 15.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .background(
            color = if (isSelected) navBg else lightBlue,
        )
        .clickable { onTap() }
        .padding(horizontal = 15.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center) {
        Text(text = label,
            fontFamily = MONTSERRAT,
            fontSize = 16.sp,
            color = Color.White)
    }
}

@Composable
fun DailyThought() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(card1)
            .drawBehind {
                val height = size.height
                val cx = size.width
                val cy = size.height / 4f
                val radius1 = height*1.2f
                val radius2 = height*1f

                drawCircle(Color.White.copy(alpha = 0.15f), radius1, Offset(cx, cy))
                drawCircle(Color.White.copy(alpha = 0.15f), radius2, Offset(cx, cy))
            }) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier,
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center) {
                Text(text = "Daily Thought",
                    fontSize = 18.sp,
                    fontFamily = MONTSERRAT,
                    fontWeight = FontWeight.Medium,
                    color = HeadLineText)
                Text(
                    text = "Mediation 3-10 min",
                    fontSize = 12.sp,
                    fontFamily = MONTSERRAT,
                    color = Color.White,
                )
            }
            Box(modifier = Modifier
                .size(45.dp)
                .background(navBg, CircleShape),
                contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Search",
                    tint = Color.White)
            }
        }
    }
}

@Composable
fun FetureTitle() {
    Text(
        modifier = Modifier.padding(horizontal = 15.dp),
        text = "Featured", fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
}

@Composable
fun FeaturedItems() {
    val modifier = Modifier
    Column(modifier = Modifier
        .padding(horizontal = 15.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            FeaturedTile(modifier
                .padding(end = 7.5.dp)
                .weight(1f), ViewsData.featuredItems.get(0))
            FeaturedTile(modifier
                .padding(start = 7.5.dp)
                .weight(1f), ViewsData.featuredItems.get(1))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            FeaturedTile(modifier
                .padding(end = 7.5.dp)
                .weight(1f), ViewsData.featuredItems.get(2))
            FeaturedTile(modifier
                .padding(start = 7.5.dp)
                .weight(1f), ViewsData.featuredItems.get(3))
        }
    }
}

@Composable
fun FeaturedTile(modifier: Modifier, feturedItem: FeaturedInfo) {
    MyBox(modifier = modifier
        .fillMaxWidth()
        .aspectRatio(0.95f)
        .clip(RoundedCornerShape(15.dp)),
        backgroundColor = feturedItem.backgroundColor) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround) {
            Text(text = feturedItem.title,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = feturedItem.icon),
                    contentDescription = feturedItem.title,
                    tint = Color.White
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(navBg)
                        .padding(horizontal = 15.dp, vertical = 8.dp),
                ) {
                    Text(text = "Start",
                        fontSize = 14.sp,
                        color = Color.White,
                        fontFamily = MONTSERRAT)
                }
            }
        }
    }
}

@Composable
fun MyBox(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .drawBehind {
                val height = size.height
                val width = size.width

                val sp = Offset(0f, height * 0.38f)
                val p1 = Offset(width * 0.1f, height * 0.5f)
                val p2 = Offset(width * 0.3f, height * 0.25f)
                val p3 = Offset(width * 0.45f, height * 0.1f)
                val p4 = Offset(width * 0.60f, height * 0.48f)
                val p5 = Offset(width * 0.75f, height * .8f)
                val p6 = Offset(width * 1f, height * 0.15f)

                val path1 = Path().apply {
                    moveTo(sp.x, sp.y)
                    quadraticBezierTo(p1.x, p1.y, p2.x, p2.y)
                    quadraticBezierTo(p3.x, p3.y, p4.x, p4.y)
                    quadraticBezierTo(p5.x, p5.y, p6.x, p6.y)
                    lineTo(width, height)
                    lineTo(0f, height)
                    close()
                }
                drawPath(path1, Color.White.copy(alpha = 0.15f))


                val sp2 = Offset(0f, height * 0.45f)
                val p2_1 = Offset(width * 0.1f, height * 0.55f)
                val p2_2 = Offset(width * 0.23f, height * 0.45f)
                val p2_3 = Offset(width * 0.38f, height * 0.35f)
                val p2_4 = Offset(width * 0.45f, height * 0.58f)
                val p2_5 = Offset(width * 0.65f, height * 1.3f)
                val p2_6 = Offset(width * 1f, height * 0.25f)

                val path2 = Path().apply {
                    moveTo(sp2.x, sp2.y)
                    quadraticBezierTo(p2_1.x, p2_1.y, p2_2.x, p2_2.y)
                    quadraticBezierTo(p2_3.x, p2_3.y, p2_4.x, p2_4.y)
                    quadraticBezierTo(p2_5.x, p2_5.y, p2_6.x, p2_6.y)
                    lineTo(width, height)
                    lineTo(0f, height)
                    close()
                }
                drawPath(path2, Color.White.copy(alpha = 0.2f))


            },
        contentAlignment = contentAlignment,
        content = content
    )
}