package com.android.practice.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.practice.lemonade.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    val stage = remember {
        mutableStateOf(1)
    }
    val imageResource = when (stage.value) {
        1 -> R.drawable.img_lemon_tree
        2 -> R.drawable.img_lemon_squeeze
        3 -> R.drawable.img_lemon_drink
        4 -> R.drawable.img_lemon_restart
        else -> {
            stage.value = 1
            R.drawable.img_lemon_tree
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.lemonade_first), modifier.padding(bottom = 10.dp))
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(
                id = R.string.lemonade_first_description
            ),
            modifier = modifier
                .border(
                    width = 2.dp, shape = RoundedCornerShape(4.dp), color = colorResource(
                        id = R.color.blue_69cdd8
                    )
                )
                .clickable {
                    if (stage.value == 2) {
                        if ((1..4).random() == 4)
                            stage.value++
                    } else {
                        stage.value++
                    }
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    DiceRollerTheme {
        Lemonade()
    }
}