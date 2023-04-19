package com.android.practice.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.practice.taskcompleted.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                TaskCompletedApp()
            }
        }
    }
}

@Composable
fun TaskCompletedWithImageAndTexts(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = "check"
        )
        Text(
            text = stringResource(id = R.string.title),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(text = stringResource(id = R.string.desc), fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletedApp() {
    DiceRollerTheme {
        TaskCompletedWithImageAndTexts()
    }
}