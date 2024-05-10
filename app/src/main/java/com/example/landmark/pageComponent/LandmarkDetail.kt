package com.example.landmark.pageComponent

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.landmark.R
import com.example.landmark.component.Button
import com.example.landmark.data.Landmark

@Composable
fun LandmarkDetail(
    landmark: Landmark = Landmark.BurjKhalifa,
    navigateBack: () -> Unit = {}
) {
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp, 0.dp),
    ) {
        Button (
            modifier = Modifier.padding(0.dp, 16.dp),
            onClick = navigateBack
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painterResource(R.drawable.navigate_back),
                    stringResource(R.string.navigate_back),
                    Modifier.height(16.dp)
                )
                Text(stringResource(R.string.navigate_back))
            }
        }

        Column (
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(0.dp, 0.dp, 0.dp, 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                landmark.getImage(),
                landmark.getName(),
                modifier = Modifier
                    .aspectRatio(.5f)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Column (
                Modifier
                    .fillMaxWidth()
                    .background(Color(0x1000b0ff))
                    .padding(16.dp)
            ) {

                Row (
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "${landmark.year}",
                        Modifier.weight(1f),
                        fontSize = 4.em,
                        maxLines = 1
                    )

                    Image(
                        landmark.region.getImage(),
                        landmark.region.getName(),
                        Modifier.height(18.dp)
                    )

                    Text(
                        landmark.region.getName(),
                        fontSize = 4.em
                    )
                }

                Text(
                    landmark.getName(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 5.em,
                )

                Text(
                    "${landmark.height}m / ${landmark.heightFeet}ft",
                )
            }

            Button (
                onClick = {
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse(landmark.location)
                    context.startActivity(openURL)
                }
            ) {
                Text( "Open in google map")
            }
        }
    }
}