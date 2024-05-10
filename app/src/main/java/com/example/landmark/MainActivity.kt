package com.example.landmark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.landmark.data.Landmark
import com.example.landmark.pageComponent.LandmarkDetail
import com.example.landmark.pageComponent.LandmarkList
import com.example.landmark.ui.theme.Hw2_20240508Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hw2_20240508Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    var landmarkState: Landmark by remember {
        mutableStateOf(Landmark.Taipei101)
    }

    NavHost(
        navController = navController,
        startDestination = "/list"
    ) {
        composable("/list") {
            LandmarkList { landmarkName ->
                navController.navigate("/detail/$landmarkName")
            }
        }

        composable(
            "/detail/{landmarkName}",
            arguments = listOf(navArgument("landmarkName") { type = NavType.StringType })
        ) {
            val landmarkName = navController.currentBackStackEntry?.arguments?.getString("landmarkName")
            val landmark = if (landmarkName != null) Landmark.valueOf(landmarkName) else {null}

            if (landmark != null) {
                landmarkState = landmark
            }

            LandmarkDetail(landmarkState) {
                navController.navigateUp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Hw2_20240508Theme {
        LandmarkList()
    }
}