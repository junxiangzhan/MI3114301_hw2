package com.example.landmark.pageComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.landmark.component.Button
import com.example.landmark.data.Landmark

@Composable
fun LandmarkList(
    navigate: (route: String) -> Unit = {}
) {
    val landmarks = Landmark.entries

    Column(
        modifier = Modifier
            .padding(32.dp, 8.dp, 32.dp, 16.dp),
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "List of Tallest Buildings",
                fontSize = 6.em,
                textAlign = TextAlign.Center,
                lineHeight = 1.em
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(landmarks.size) { index ->
                val landmark = landmarks[index]

                Button (
                    onClick = { navigate(landmark.name) }
                ) {
                    Text(
                        text = String.format("No.%2d", index + 1),
                        lineHeight = 1.5.em,
                        fontWeight = FontWeight.SemiBold
                    )
                    Image(
                        modifier = Modifier
                            .width(40.dp),
                        painter = landmark.region.getImage(),
                        contentDescription = landmark.region.getName()
                    )
                    Text(
                        modifier = Modifier
                            .weight(1f),
                        text = landmark.getName(),
                        lineHeight = 1.5.em
                    )
                    Text(
                        text = String.format("%.1fm", landmark.height),
                        lineHeight = 1.5.em
                    )
                }
            }
        }
    }
}

