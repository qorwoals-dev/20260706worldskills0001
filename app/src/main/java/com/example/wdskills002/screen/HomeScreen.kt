package com.example.wdskills002.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wdskills002.R

@Composable
fun HomeScr(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("My", fontSize = 30.sp, color = Color.Black)
            Text("10 Points", fontSize = 30.sp, color = Color.Gray)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.app_icon),
                contentDescription = null
            )
            Text("Camping Mate", fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier
                    .height(90.dp)
                    .width(320.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                onClick = {}
            ) {
                Image(
                    painter = painterResource(R.drawable.img3),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column(

                ) {
                    Text("나의 캠핑 스타일", color = Color.Black)
                    Row(

                    ) {
                        Text("{숙박유형}", color = Color.Black)
                        Spacer(modifier = Modifier.width(20.dp))
                        Text("{인원}", color = Color.Black)
                    }
                }

            }
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = {}
            ) {
                Text("추천 받기", fontSize = 20.sp, color = Color.Black)

            }
        }



    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScr()

}