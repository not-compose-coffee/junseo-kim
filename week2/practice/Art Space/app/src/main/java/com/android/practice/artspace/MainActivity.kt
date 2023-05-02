package com.android.practice.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.practice.artspace.data.model.Quotation
import com.android.practice.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ArtSpace(viewModel.getQuotations())
            }
        }
    }
}

@Composable
fun ArtSpace(quotations: List<Quotation>, modifier: Modifier = Modifier) {
    var position by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.6f),
            shadowElevation = 3.dp,
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(15.dp)
        ) {
            Image(
                painter = painterResource(id = quotations[position].personImageResource),
                contentDescription = "charactor",
                modifier = modifier.padding(12.dp)
            )
        }
        Card(
            modifier
                .fillMaxWidth(0.8f)
                .wrapContentHeight()
                .padding(top = 20.dp),
            elevation = CardDefaults.cardElevation(3.dp),
        ) {
            Column(modifier = modifier.padding(20.dp)) {
                Text(
                    text = quotations[position].personName,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Row() {
                    Text(
                        text = quotations[position].wiseSaying,
                        fontSize = 16.sp
                    )
                }
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    if (position == 0) position = 2
                    else position--
                }, modifier.fillMaxWidth(0.45f),
                elevation = ButtonDefaults.buttonElevation(3.dp)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = modifier.fillMaxWidth(0.1f))
            Button(
                onClick = {
                    if (position == 2) position = 0
                    else position++
                }, modifier.fillMaxWidth(),
                elevation = ButtonDefaults.buttonElevation(3.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace(MainViewModel().getQuotations())
    }
}