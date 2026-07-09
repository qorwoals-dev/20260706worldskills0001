package com.example.wdskills002.screen

import android.text.Layout
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
fun PoinCharge(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Button(
                modifier = Modifier
                    .width(110.dp)
                    .height(50.dp),
                onClick = {}
            ) {
                Image(
                    painter = painterResource(R.drawable.arrowback),
                    contentDescription = null
                )
                Text("이전", color = Color.Black)

            }

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
            Row() {
                Text("포인트 충전", fontSize = 30.sp, color = Color.Black)
                Image(
                    painter = painterResource(R.drawable.img7),
                    contentDescription = null
                )
            }











            Button(
                modifier = Modifier
                    .height(90.dp)
                    .width(320.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                onClick = {}
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img7),
                            contentDescription = null
                        )
                        Text("10 Points", color = Color.Black)
                    }

                    Button(
                        onClick = {}
                    ) {

                    }
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(330.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Image(
                    painter = painterResource(R.drawable.img7),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text("포인트 30개", fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(40.dp))
                Text("300원", fontSize = 20.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(330.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Image(
                    painter = painterResource(R.drawable.img7),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text("포인트 50개", fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(40.dp))
                Text("500원", fontSize = 20.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(330.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Image(
                    painter = painterResource(R.drawable.img7),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text("포인트 100개", fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(30.dp))
                Text("1,000원", fontSize = 15.sp, color = Color.Black)
            }


            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(330.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Image(
                    painter = painterResource(R.drawable.img7),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text("포인트 200개", fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(30.dp))
                Text("2,000원", fontSize = 15.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(330.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Image(
                    painter = painterResource(R.drawable.img7),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text("포인트 300개", fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(30.dp))
                Text("3,000원", fontSize = 15.sp, color = Color.Black)
            }
        }
    }
}

@Composable
fun HomeScr(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
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
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(1) {
                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .width(130.dp),

                    ) {
                    Image(
                        painter = painterResource(R.drawable.app_icon),
                        contentDescription = null
                    )
                    Text("[캠핑 리스트]")
                }
            }

            items(1) {
                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .width(130.dp),

                    ) {
                    Image(
                        painter = painterResource(R.drawable.app_icon),
                        contentDescription = null
                    )
                    Text("[캠핑 리스트]")
                }
            }
            items(1) {
                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .width(130.dp),

                    ) {
                    Image(
                        painter = painterResource(R.drawable.app_icon),
                        contentDescription = null
                    )
                    Text("[캠핑 리스트]")
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(300.dp),
                onClick = {}
            ) {
                Spacer(modifier = Modifier.width(50.dp))
                Text("포인트 충전", color = Color.White, fontSize = 25.sp)
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(R.drawable.arrowgo),
                    contentDescription = null
                )

            }
        }




    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScr()

}