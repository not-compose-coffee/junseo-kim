package com.android.practice.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.practice.composequadrant.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantWithString(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = modifier.fillMaxHeight(0.5f)) {
            Column(
                modifier = modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(Color.Green)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(R.string.first_title, R.string.first_desc)
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(R.string.second_title, R.string.second_desc)
            }
        }
        Row(modifier = modifier.fillMaxHeight()) {
            Column(
                modifier = modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(Color.Cyan)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(R.string.third_title, R.string.third_desc)
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.LightGray)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(R.string.fourth_title, R.string.fourth_desc)
            }
        }
    }
}

@Composable
fun Card(titleStringResource: Int, descStringResource: Int) {
    Text(
        text = stringResource(
            id = titleStringResource
        ), fontWeight = FontWeight.Bold, modifier = modifier.padding(bottom = 16.dp)
    )
    Text(
        text = stringResource(
            id = descStringResource
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantApp() {
    DiceRollerTheme {
        ComposeQuadrantWithString()
    }
}