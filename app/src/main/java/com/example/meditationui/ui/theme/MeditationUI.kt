@file:OptIn(ExperimentalFoundationApi::class)

package com.example.meditationui.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditationui.Feature
import com.example.meditationui.R

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection("Akhil")
            ChipSection(chipList = listOf("Sweet Sleep", "Insomnia", "Depression"))
            CurrentMeditation()
        }
    }
}

@Composable
fun GreetingSection(name: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning, $name!!",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "We wish you have a good day",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search icon",
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun ChipSection(chipList: List<String>) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items(chipList.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clickable {
                        selectedItemIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedItemIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(16.dp)
            ) {
                Text(text = chipList[it], color = Color.White)
            }
        }
    }
}

@Composable
fun CurrentMeditation() {

    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column (
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Daily Thought", style = MaterialTheme.typography.titleLarge)
            Text(text = "Meditation | 3-10 min", style = MaterialTheme.typography.titleMedium)
        }

        Box(modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(BlueViolet1)
            .padding(10.dp),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "play",
                modifier = Modifier.size(16.dp)
            )
        }

    }
}

@Composable
fun FeatureSection(list: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(list.size){

            }
        }
    }
}

@Composable
fun Feature(feature: Feature){
    Box(modifier = Modifier
        .padding(7.5.dp)
        .aspectRatio(1f)
        .clip(RoundedCornerShape(10.dp))
        .background(feature.darkColor)
    ){

    }
}