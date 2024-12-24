package com.norihiro.processing_advent_calender_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.norihiro.processing_advent_calender_2024.ui.theme.MyTheme
import kotlin.random.Random

// Androidアプリのメインアクティビティ
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RandomCircles(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

// ここで円をランダムに描画
@Composable
fun RandomCircles(modifier: Modifier = Modifier) {
    val randomSeed = Random(42)
    val pallet = listOf(
            "#B74340",
            "#F2CE0E",
            "#0E1F28",
            "#266BB3",
        ).map {
            Color(android.graphics.Color.parseColor(it))
        }
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        for (i in 1..20) {
            drawCircle(
                color = pallet.random(randomSeed),
                radius = (50..150).random(randomSeed).toFloat(),
                center =
                    Offset(
                        x = (0..size.width.toInt()).random(randomSeed).toFloat(),
                        y = (0..size.height.toInt()).random(randomSeed).toFloat(),
                    ),
            )
        }
    }
}

// プレビュー
@Preview(showBackground = true)
@Composable
private fun AppPreview() {
    MyTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            RandomCircles(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}
