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
import androidx.compose.runtime.rememberCoroutineScope
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
import org.json.JSONArray
import org.json.JSONObject
import kotlin.collections.associate

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.min
import kotlin.random.Random



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
            list = dummyGroundList,
            onBack = {step = 1},
            onNext = {step = 5}
        )
    }
}


val dummyGroundList = listOf(
    GroundModel("1", "난지 캠핑장", "서울 도심 속에서 즐기는 바비큐"),
    GroundModel("2", "자라섬 캠핑장", "강바람과 함께하는 넓은 잔디광장"),
    GroundModel("3", "몽산포 캠핑장", "울창한 소나무 숲과 갯벌 체험"),
    GroundModel("4", "포천 캠핑마을", "포천 계곡 옆 시원한 글램핑"),
    GroundModel("5", "가평 별빛 캠프", "밤하늘 은하수를 감상하는 명당"),
    GroundModel("6", "대부도 나라 캠핑", "서해안 낙조가 예술인 캠핑장"),
    GroundModel("7", "태안 학암포", "파도 소리 들으며 잠드는 오토캠핑"),
    GroundModel("8", "평창 숲속 캠프", "해발 700m 피톤치드 가득한 곳"),
    GroundModel("9", "양평 수목원 캠프", "아이들과 함께 가기 좋은 수목원")
)
data class GroundModel(
    val id: String,          // 카드 식별용 고유 ID (예: "camp_01")
    val name: String,        // 캠핑장 이름
    val description: String  // 캠핑장 한 줄 설명
)
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
    var context = LocalContext.current
    var showdilog by remember { mutableStateOf(false) }

    var selectedSeason by remember { mutableStateOf("선택 안됨") }
    var selectedPetFriendly by remember { mutableStateOf("선택 안됨") }
    var selectedPowerZone by remember { mutableStateOf("선택 안됨") }

    var currentcategory by remember { mutableStateOf("") }



    val (seasonOptions, petOptions, powerOptions) = remember {
        try {
            val array = JSONArray(context.assets.open("camping_styles_data.json").bufferedReader().use { it.readText() })
            Triple(
                (0 until array.length()).map { array.getJSONObject(it).getString("season_tag") }.distinct(),
                (0 until array.length()).map { array.getJSONObject(it).getBoolean("pet_friendly") }.distinct(),
                (0 until array.length()).map { array.getJSONObject(it).getBoolean("power_zone") }.distinct()
            )
        } catch (e: Exception) {
            Triple(emptyList(), emptyList(), emptyList())
        }
    }



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

            val categories = listOf(
                Triple("계절", selectedSeason, "season_tag"),
                Triple("반려동물", selectedPetFriendly, "pet_friendly"),
                Triple("전기구역", selectedPowerZone, "power_zone")
            )
            LazyRow(
                modifier = Modifier
                    .padding(start = 40.dp)
                    .fillMaxWidth()

            ) {
                items(categories.size){ index ->
                    val (title, selectedValue, key) = categories[index]
                    Card(
                        modifier = Modifier.padding(7.dp).height(130.dp).width(130.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("$title 선택", fontSize = 18.sp)
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                modifier = Modifier.height(50.dp).width(110.dp),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    currentcategory = key
                                    showdilog = true
                                }
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(selectedValue, fontSize = 12.sp)
                                    Image(painter = painterResource(R.drawable.arrowgo), contentDescription = null)
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
                onClick = {
                    if (campingmate.point >= 10) {
                        campingmate.point -= 10
                        Toast.makeText(context, "스타일 분석을 시작합니다!", Toast.LENGTH_SHORT).show()
                        onNext()
                    } else {
                    Toast.makeText(context, "포인트가 부족합니다.", Toast.LENGTH_SHORT).show()
                    }
                }

            ) {
                Text("포인트 10개로 스타일 찾기", color = Color.White, fontSize = 20.sp)
                Image(
                    painter = painterResource(R.drawable.arrowgo),
                    contentDescription = null
                )
            }


            if (showdilog) {
                val options: List<Any> = when (currentcategory) {
                    "season_tag" -> seasonOptions
                    "pet_friendly" -> petOptions
                    "power_zone" -> powerOptions
                    else -> emptyList()
                }

                AlertDialog(
                    onDismissRequest = { showdilog = false },
                    title = { Text("선택해주세요") },
                    text = {
                        Column {
                            options.forEach { option ->
                                // Boolean 값을 사용자가 직관적으로 인식할 수 있게 치환
                                val displayText = when (option) {
                                    true -> "가능/있음"
                                    false -> "불가/없음"
                                    else -> option.toString()
                                }

                                TextButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    onClick = {
                                        when (currentcategory) {
                                            "season_tag" -> selectedSeason = displayText
                                            "pet_friendly" -> selectedPetFriendly = displayText
                                            "power_zone" -> selectedPowerZone = displayText
                                        }
                                        showdilog = false
                                    }
                                ) {
                                    Text(displayText, fontSize = 16.sp, color = Color.Black)
                                }
                            }
                        }
                    },
                    confirmButton = {
                        TextButton(onClick = { showdilog = false }) { Text("취소") }
                    }
                )
            }

        }
    }

}

@Composable
fun Shuffle(
    list: List<GroundModel>, // 외부에서 넘어오는 캠핑장 리스트
    onBack: () -> Unit,
    onNext: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // 애니메이션 제어용 상태 변수들
    var flag by remember { mutableStateOf(false) }
    var flag2 by remember { mutableStateOf(false) }
    var seed by remember { mutableStateOf(0) }

    // 표시할 아이템은 최대 9개로 제한
    val displayedList = remember(list) { list.subList(0, min(list.size, 9)) }

    // 셔플 시 흩어질 랜덤 좌표값
    val randoms = remember(seed, displayedList) {
        displayedList.associate { it.id to Triple(Random.nextFloat(), Random.nextFloat(), Random.nextFloat()) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null
        )
        Text("Camping Mate", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(30.dp))
        Text("당신의 스타일에 맞는", fontSize = 20.sp, color = Color.Black)
        Text("캠핑장은 어디일까요?", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))

        // 💡 하얀색 박스 (BoxWithConstraints로 내부 카드 크기 유동적 계산)
        BoxWithConstraints(
            modifier = Modifier
                .height(470.dp)
                .width(350.dp)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
        ) {
            val width = (maxWidth - 24.dp) / 3
            val height = (maxHeight - 24.dp) / 3

            displayedList.forEachIndexed { index, e ->
                val (r1, r2, r3) = randoms[e.id] ?: Triple(0.5f, 0.5f, 0f)

                // 위치 및 회전 애니메이션
                val left by animateDpAsState(
                    targetValue = if (flag) (width + 12.dp) * (index / 3) else (100 * r1 + 50).dp,
                    animationSpec = tween(300, easing = if (flag) EaseIn else EaseOut),
                    label = "left"
                )
                val top by animateDpAsState(
                    targetValue = if (flag) (height + 12.dp) * (index % 3) else (150 * r2 + 75).dp,
                    animationSpec = tween(300, easing = if (flag) EaseIn else EaseOut),
                    label = "top"
                )
                val turns by animateFloatAsState(
                    targetValue = if (flag) 0f else r3,
                    animationSpec = tween(300),
                    label = "turns"
                )

                Box(
                    modifier = Modifier
                        .offset(x = left, y = top)
                        .clickable(enabled = flag && !flag2) {
                            Toast.makeText(context, "${e.name} 선택됨", Toast.LENGTH_SHORT).show()
                            onNext()
                        }
                ) {
                    val img = remember(e.id) { Random.nextInt(9) + 1 }
                    val turnsDegrees = turns * 360f

                    // 💡 원본 카드 디자인 적용 (AssetImage 사용하도록 매핑)
                    Column(
                        modifier = Modifier
                            .graphicsLayer { rotationZ = turnsDegrees }
                            .size(width, height)
                            .background(Color.White, RoundedCornerShape(16.dp)) // 원본처럼 하얀색 배경 카드
                            .padding(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Box(Modifier.weight(1f).fillMaxWidth().clip(RoundedCornerShape(8.dp))) {
                            // 💡 원본과 똑같이 assets/camp_0$img.png 형태의 AssetImage 로딩 방식 적용
                            AsyncImage(
                                model = "file:///android_asset/camp_0$img.png", // 💡 assets 경로를 가리키는 표준 URI 형식
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(Modifier.height(6.dp))
                        Text(
                            e.name,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Black
                        )
                        Text(
                            e.description,
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Gray
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 셔플 트리거 버튼
        Button(
            modifier = Modifier
                .height(60.dp)
                .width(320.dp),
            onClick = {
                scope.launch {
                    flag2 = true
                    flag = false
                    seed++ // 위치 재생성
                    delay(500)
                    flag = true
                    flag2 = false
                }
            }
        ) {
            Text("셔플 시작하기", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 하단 이전 버튼
        Button(
            modifier = Modifier
                .height(60.dp)
                .width(320.dp),
            onClick = { onBack() }
        ) {
            Image(
                painter = painterResource(R.drawable.img6),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("이전")
        }
    }
}


@Preview(showBackground = true)
@Composable
@Preview(showBackground = true)
fun HomePreview() {

}