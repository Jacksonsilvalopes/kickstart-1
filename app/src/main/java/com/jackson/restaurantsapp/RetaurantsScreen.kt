package com.jackson.restaurantsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card

import androidx.compose.material3.CardDefaults

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackson.restaurantsapp.ui.theme.RestaurantsAppTheme
import com.jackson.restaurantsapp.Restaurant as Restaurant

@Composable
fun RestaurantsScreen() {
    LazyColumn (
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ){
        items(dummyRestaurants){
            restaurant ->   RestaurantItem(restaurant)
        }
    }


}

@Composable
fun RestaurantItem(item:Restaurant) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier.padding(8.dp),

    ) {

        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)){
            RestaurantIcon(
                Icons.Filled.Place,
                Modifier.weight(0.15f)
            )
            RestaurantDetails(
                item.title,
                item.description,
                Modifier.weight(0.85f))
        }

    }
}


@Composable
fun RestaurantIcon(icon: ImageVector, modifier: Modifier){
    Image(imageVector = icon, contentDescription = "Restaurant icon",
        modifier =modifier.padding(8.dp)
        )
}
@Composable
 private fun RestaurantDetails(title: String, description: String, modifier: Modifier ){
    Column (modifier=modifier  ){
        Text(text = title,
            style = MaterialTheme.typography.headlineLarge)
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onSurface.copy(alpha = 0.52f)
        ) { Text(text = description, style = MaterialTheme.typography.bodyLarge) }

    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RestaurantsAppTheme {
        RestaurantsScreen()
    }
}
