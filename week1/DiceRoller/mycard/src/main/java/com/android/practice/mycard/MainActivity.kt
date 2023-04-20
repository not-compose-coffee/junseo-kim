package com.android.practice.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.practice.mycard.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                MyCardApp()
            }
        }
    }
}

@Composable
fun MtyCardWithImageAndTexts(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.navy_142f40)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = modifier.fillMaxHeight(0.1f))
        Image(
            painter = painterResource(id = R.drawable.img_junseo_profile),
            contentDescription = "image of junseo",
            modifier = modifier.fillMaxWidth(0.5f)
        )
        Text(
            text = stringResource(R.string.profile_name),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.green_android_3ddc84),
            modifier = modifier.padding(14.dp)
        )
        Text(text = stringResource(R.string.profile_job), fontSize = 22.sp, color = Color.White)
        Spacer(modifier = modifier.fillMaxHeight(0.1f))
        Divider()
        Row(
            modifier = modifier.fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_call),
                contentDescription = "call icon",
                modifier.padding(top = 10.dp, bottom = 10.dp, end = 20.dp),
                colorFilter = ColorFilter.tint(colorResource(id = R.color.green_android_3ddc84))
            )
            Text(text = stringResource(R.string.profile_phone_number), color = Color.White)
        }
        Divider()
        Row(
            modifier = modifier.fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "call share",
                modifier.padding(top = 10.dp, bottom = 10.dp, end = 20.dp),
                colorFilter = ColorFilter.tint(colorResource(id = R.color.green_android_3ddc84))
            )
            Text(text = stringResource(R.string.profile_share_desc), color = Color.White)
        }
        Divider()
        Row(
            modifier = modifier.fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "call email",
                modifier.padding(top = 10.dp, bottom = 10.dp, end = 20.dp),
                colorFilter = ColorFilter.tint(colorResource(id = R.color.green_android_3ddc84))
            )
            Text(text = stringResource(R.string.profile_email), color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCardApp() {
    DiceRollerTheme {
        MtyCardWithImageAndTexts()
    }
}