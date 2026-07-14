package com.example.wdskills002.screen

import android.text.Layout
import android.widget.Toast
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wdskills002.R
import com.example.wdskills002.core.campingmate


@Composable
fun HomeCon(startstep : Int = 0){
    var step by remember { mutableStateOf(1) }
    when(step){
        1 ->
            HomeScr(
                campstylebtn = {step = 3},
                pointcharbtn = {step = 2}
            )
        2 ->
            PoinCharge(
                onBack = { step = 1}
            )
        3 ->
            Campstyle(
                onBack = {step = 1},
                onNext = {step = 4}
            )
        4 -> Shuffle(
            onBack = {step = 1}
        )

    }
}

@Composable
fun PoinCharge(onBack: () -> Unit){
    var showdialog by remember { mutableStateOf(false) }
    var context = LocalContext.current
    var selectedPoint by remember { mutableStateOf(0) }
    var refreshTrigger by remember { mutableStateOf(0) }
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
                onClick = {
                    onBack()
                }
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
                        key(refreshTrigger){
                            Image(
                                painter = painterResource(R.drawable.img7),
                                contentDescription = null
                            )
                            Text(campingmate.point.toString() + " Points", fontSize = 20.sp, color = Color.Black)
                        }

                    }
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            ChargePointbtn(
                pointc = 10,
                price = "",
                onClick = { selectedPoint = 10; showdialog = true }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ChargePointbtn(
                pointc = 30,
                price = "300원",
                onClick = { selectedPoint = 30; showdialog = true }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ChargePointbtn(
                pointc = 50,
                price = "500원",
                onClick = { selectedPoint = 50; showdialog = true }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ChargePointbtn(
                pointc = 100,
                price = "1,000원",
                onClick = { selectedPoint = 100; showdialog = true }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ChargePointbtn(
                pointc = 200,
                price = "2,000원",
                onClick = { selectedPoint = 200; showdialog = true }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ChargePointbtn(
                pointc = 300,
                price = "3,000원",
                onClick = { selectedPoint = 300; showdialog = true }
            )

        }
    }
    if(showdialog){
        AlertDialog(
            onDismissRequest = { },
            title = { Text("확인") },
            text = { Text("포인트 ${selectedPoint }개를 구매하시겠습니까?") },
            dismissButton = {
                TextButton(onClick = { showdialog = false }) { Text("취소") }
            },
            confirmButton = {
                TextButton(onClick = {
                    campingmate.point += selectedPoint
                    Toast.makeText(context,"$selectedPoint 개 충전완료", Toast.LENGTH_SHORT).show()
                    showdialog = false
                }) { Text("확인") }

            },
        )

    }

}

@Composable
fun ChargePointbtn(
    pointc : Int,
    price : String,
    onClick : () -> Unit,
){
    Button(
        modifier = Modifier
            .height(50.dp)
            .width(340.dp),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.img7),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(40.dp))
        Text("포인트 $pointc 개", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.width(40.dp))
        Text(price, fontSize = 15.sp, color = Color.Black)
    }
}

@Composable
fun HomeScr( campstylebtn : () -> Unit, pointcharbtn : () -> Unit){
    var refresh by remember { mutableStateOf(0) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
    ) {
        Row(
            modifier = Modifier
                .padding(25.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("My", fontSize = 30.sp, color = Color.Black)
            key(refresh) {
                Text("${campingmate.point} Points", fontSize = 30.sp, color = Color.Gray)
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
                onClick = {
                    campstylebtn()
                }
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
            items(3) {
                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .width(130.dp),


                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .height(120.dp)
                                .padding(10.dp)
                                .background(color = Color.White),
                            painter = painterResource(R.drawable.app_icon),
                            contentDescription = null

                        )
                        Text("[캠핑 리스트]")

                    }

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
                onClick = {
                    pointcharbtn()
                }
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

@Composable
fun Campstyle(onBack: () -> Unit,onNext: () -> Unit){
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
                onClick = {
                    onBack()
                }
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
            Text("나의 캠핑 성향으로", fontSize = 20.sp, color = Color.Black)
            Row() {
                Text("알아보는 스타일 추천", fontSize = 20.sp, color = Color.Black)
                Image(
                    painter = painterResource(R.drawable.img6),
                    contentDescription = null
                )
            }
            Text("보유 포인트: " + campingmate.point + " points", fontSize = 20.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .height(90.dp)
                    .width(300.dp),
                onClick = {},
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("style_preview.txt 활용", color = Color.Black)
            }
            Spacer(modifier = Modifier.height(30.dp))
            LazyRow(
                modifier = Modifier
                    .padding(start = 40.dp)
                    .fillMaxWidth()

            ) {
                items(3){
                    Card(
                        modifier = Modifier
                            .padding(7.dp)
                            .height(130.dp)
                            .width(130.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("계절 선택", fontSize = 20.sp)
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(100.dp),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {}
                            ) {
                                Row(

                                ) {
                                    Text("계절")
                                    Image(
                                        painter = painterResource(R.drawable.arrowgo),
                                        contentDescription = null
                                    )
                                }

                            }
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                modifier = Modifier
                    .width(330.dp)
                    .height(70.dp),
                onClick = {}
            ) {
                Text("포인트 10개로 스타일 찾기", color = Color.White, fontSize = 20.sp)
                Image(
                    painter = painterResource(R.drawable.arrowgo),
                    contentDescription = null
                )
            }













        }
    }

}


@Composable
fun Shuffle(onBack: () -> Unit){

}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Campstyle(onBack = {}, onNext = {})
}